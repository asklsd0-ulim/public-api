package gov.mfds.example.udi.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class SterilizationMethodDTO {

    @JsonProperty("order")
    private Integer order;

    /**
     * 멸균방법 코드
     */
    @JsonProperty("code")
    private String sterilizationMethodCode = "";

    /**
     * 멸균방법
     */
    @JsonProperty("name")
    private String sterilizationMethodName = "";


    /**
     * 기타멸균방법
     */
    @JsonProperty("etc")
    private String etcSterilizationMethod = "";

}
