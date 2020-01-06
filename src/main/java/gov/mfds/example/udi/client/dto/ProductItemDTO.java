package gov.mfds.example.udi.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.mfds.example.udi.enums.CobFlagCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ProductItemDTO {
    /**
     * 품목일련번호
     */
    @JsonProperty("meddevItemSeq")
    private String meddevItemSeq;
    /**
     * 품목명
     */
    @JsonProperty("itemName")
    private String itemName;
    /**
     * 등급
     */
    @JsonProperty("grade")
    private String grade;
    /**
     * 품목허가번호
     */
    @JsonProperty("meddevItemNo")
    private String meddevItemNo;
    /**
     * 품목허가일자
     */
    @JsonProperty("permitDate")
    private String permitDate;

    /**
     * 형명(모델명)
     */
    @JsonProperty("mebTypeName")
    private String mebTypeName;

    /**
     * 수출용 여부
     */
    @JsonProperty("isForExport")
    private Boolean exportYn;

    /**
     * 제조/수입 구분
     */
    @JsonProperty("cobFlagCode")
    private CobFlagCode cobFlagCode;
}
