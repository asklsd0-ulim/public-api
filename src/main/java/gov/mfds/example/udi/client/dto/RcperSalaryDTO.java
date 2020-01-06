package gov.mfds.example.udi.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class RcperSalaryDTO {
    @JsonProperty("order")
    private Integer order;

    /**
     * 요양급여 재료대 코드
     */
    @JsonProperty("code")
    private String rcperSalaryCode = "";

    /**
     * 요양급여_재료대_품목명
     */
    @JsonProperty("name")
    private String rcperSalaryItemName = "";


    /**
     * 요양급여_치료_재료대_중분류_명
     */
    @JsonProperty("mlsfcName")
    private String rcperSalaryMlsfcName = "";

}
