package gov.mfds.example.oauth2;

import gov.mfds.example.oauth2.client.AccessToken;
import gov.mfds.example.oauth2.client.OAuthClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class InMemoryTokenStore implements TokenStore {
    private OAuthClient oAuthClient;
    private String clientId;
    private String secret;

    private AccessToken accessToken;

    public InMemoryTokenStore(OAuthClient oAuthClient,
                              @Value("${oauth.client-id}") String clientId,
                              @Value("${oauth.secret}") String secret) {
        this.oAuthClient = oAuthClient;
        this.clientId = clientId;
        this.secret = secret;
    }

    @Override
    public String get() {
        if (accessToken == null || accessToken.isExpired(LocalDateTime.now())) {
            accessToken = oAuthClient.obtainAccessToken(clientId, secret);
        }
        return accessToken.getAccessToken();
    }
}
