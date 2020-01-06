package gov.mfds.example.util;

import gov.mfds.example.oauth2.TokenStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class PublicApiRestTemplate {
    private TokenStore tokenStore;
    private RestTemplate restTemplate;
    private String baseUrl;

    @Autowired
    public PublicApiRestTemplate(TokenStore tokenStore,
                                 RestTemplate restTemplate,
                                 @Value("${api.base-url}") String baseUrl) {
        this.tokenStore = tokenStore;
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
    }
    public <R> ResponseEntity<R> get(String uri, MultiValueMap<String, Object> params, Class<R> returnType) {
        HttpHeaders headers = makeAuthorizationHeader();

        String uriString = buildUri(uri, params);

        HttpEntity httpEntity = new HttpEntity(headers);
        ResponseEntity<R> responseEntity = restTemplate.exchange(uriString,
                HttpMethod.GET, httpEntity, returnType);

        return responseEntity;
    }

    public <R> ResponseEntity<Paged<R>> getList(String uri, MultiValueMap<String, Object> params, Class<R> returnType)  {
        HttpHeaders headers = makeAuthorizationHeader();

        String uriString = buildUri(uri, params);

        HttpEntity httpEntity = new HttpEntity(headers);
        ResponseEntity<Paged<R>> responseEntity = restTemplate.exchange(uriString,
                HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<Paged<R>>() {
                    @Override
                    public Type getType() {
                        ParameterizedType type = (ParameterizedType) super.getType();
                        return new ParameterizedType() {
                            @Override
                            public Type[] getActualTypeArguments() {
                                return new Type[] {returnType};
                            }

                            @Override
                            public Type getRawType() {
                                return type.getRawType();
                            }

                            @Override
                            public Type getOwnerType() {
                                return type.getOwnerType();
                            }
                        };
                    }

                });
        ResponseEntity<String> raw = restTemplate.exchange(uriString, HttpMethod.GET, httpEntity, String.class);
        log.info("{}", raw.getBody());

        return responseEntity;
    }

    public <P, R> ResponseEntity<R> post(String uri, P body, Class<R> returnType) {
        HttpHeaders headers = makeAuthorizationHeader();

        HttpEntity<P> httpEntity;
        if (body != null) {
            httpEntity = new HttpEntity<>(body, headers);
        } else {
            httpEntity = new HttpEntity<>(headers);
        }
        ResponseEntity<R> responseEntity = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, returnType);

        return responseEntity;
    }

    private HttpHeaders makeAuthorizationHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + tokenStore.get());
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }

    private String buildUri(String uri, MultiValueMap<String, Object> params) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(baseUrl + uri);
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, List<Object>> entry : params.entrySet()) {
                uriBuilder.queryParam(entry.getKey(), entry.getValue());
            }
        }
        return uriBuilder.build(false).toUriString();
    }
}
