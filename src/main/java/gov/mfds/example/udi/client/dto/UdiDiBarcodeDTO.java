package gov.mfds.example.udi.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.mfds.example.udi.enums.DiCodeSystem;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UdiDiBarcodeDTO {

    /**
     * 물류바코드
     */
    @JsonProperty("barcode")
    private String lgistBrcd;

    /**
     * 포장 수량
     */
    @JsonProperty("packQuantity")
    private int packQty;

    /**
     * 포장 차수
     */
    @JsonProperty("packDegree")
    private int packDegree;

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

    /**
     * 품목일련번호
     */
    @JsonProperty("meddevItemSeq")
    private int meddevItemSeq;

    /**
     * 형명(모델)일련번호
     */
    @JsonProperty("mebTypeSeq")
    private int mebTypeSeq;


    /**
     * 물류바코드 일련번호
     */
    @JsonProperty("barcodeSeq")
    private int lgistBrcdSeq;

    /**
     * UDIDI 일련번호
     */
    @JsonProperty("udiDiSeq")
    private int udiDiSeq;

    /**
     * 구분 코드
     */
    @JsonProperty("codeSystem")
    private DiCodeSystem codeSystemFlag;

    /**
     * 사용종료 여부
     */
    @JsonProperty("isUseEnd")
    private Boolean useEndYn;

    /**
     * 공급내역 여부
     */
    @JsonProperty("isSupplyHist")
    private Boolean supplyHistYn;

}
