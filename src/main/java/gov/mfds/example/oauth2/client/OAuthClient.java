package gov.mfds.example.oauth2.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static java.lang.String.format;

@Component
@Slf4j
public class OAuthClient {
    private RestTemplate restTemplate;
    private String authServiceUrl;

    @Autowired
    public OAuthClient(RestTemplate restTemplate,
                       @Value("${auth-service-url}") String authServiceUrl) {
        this.restTemplate = restTemplate;
        this.authServiceUrl = authServiceUrl;
    }

    public AccessToken obtainAccessToken(String clientId, String clientSecret) {
        MultiValueMap<String, String> formParam = new LinkedMultiValueMap<>();
        formParam.add("grant_type", "client_credentials");
        HttpHeaders headers = makeHeaders(clientId, clientSecret);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(formParam, headers);

        ResponseEntity<AccessToken> responseEntity = restTemplate.exchange(URI.create(authServiceUrl), HttpMethod.POST,
                requestEntity, AccessToken.class);

        AccessToken accessToken = responseEntity.getBody();
        if (accessToken == null) {
            throw new IllegalStateException("AccessToken을 가져오는데 실패");
        }
        return accessToken;
    }

    private HttpHeaders makeHeaders(String clientId, String clientSecret) {
        HttpHeaders headers = new HttpHeaders();
        String basicAuthValue = format("%s:%s", clientId, clientSecret);
        String authorization = format("%s %s", "Basic",
                Base64.getEncoder().encodeToString(basicAuthValue.getBytes(StandardCharsets.UTF_8)));
        headers.add(HttpHeaders.AUTHORIZATION, authorization);
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }
}
