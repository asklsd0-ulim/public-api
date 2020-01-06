package gov.mfds.example.udi.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@ToString
@Slf4j
public class UpdateUdiDiBarcodeDTO {

    /**
     * 사용종료 여부
     */
    @JsonProperty("isUseEnd")
    private Boolean useEndYn;
    /**
     * 포장 수량
     */
    @JsonProperty("packQuantity")
    private Integer packQty;

    /**
     * 포장 차수
     */
    @JsonProperty("packDegree")
    private Integer packDegree;

    /**
     * 사용종료 일자
     */
    @JsonProperty("useEndDate")
    private String useEndDate;

    /**
     * 사용종료 사유
     */
    @JsonProperty("useEndReason")
    private String useEndReason;

}
