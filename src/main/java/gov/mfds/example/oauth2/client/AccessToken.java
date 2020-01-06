package gov.mfds.example.oauth2.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class AccessToken {
    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private Integer expiresIn;

    private LocalDateTime created;

    public AccessToken() {
        this.created = LocalDateTime.now();
    }

    public boolean isExpired(LocalDateTime other) {
        return other.isAfter(created.plusSeconds(expiresIn));
    }
}
