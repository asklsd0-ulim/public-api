package gov.mfds.example.udi.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.mfds.example.udi.enums.DiCodeSystem;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AddUdiDiBarcodeDTO {
    /**
     * 물류바코드
     */
    @JsonProperty("barcode")
    private String lgistBrcd;

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
     * 구분 코드
     */
    @JsonProperty("codeSystem")
    private DiCodeSystem codeSystemFlag;

}
