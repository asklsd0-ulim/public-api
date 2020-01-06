package gov.mfds.example.udi.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.mfds.example.udi.enums.CobFlagCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductModelDTO {
    /**
     * 모델 시퀸스
     */
    @JsonProperty("seq")
    private String seq; //모델시퀀스

    /**
     * 허가일자
     */
    @JsonProperty("permitDate")
    private String permitDate;

    /**
     * 품목SEQ
     */
    @JsonProperty("meddevItemSeq")
    private Integer meddevItemSeq;

    /**
     * 모델명
     */
    @JsonProperty("modelName")
    private String typeName = "";

    /**
     * 품목명
     */
    @JsonProperty("itemName")
    private String itemName = "";

    /**
     * 품목허가번호
     */
    @JsonProperty("permitItemNo")
    private String meddevItemNo = "";

    /**
     * 등급
     */
    @JsonProperty("grade")
    private String grade = "";

    /**
     * 제조/수입 구분 코드
     */
    @JsonProperty("cobFlagCode")
    private CobFlagCode cobFlagCode;

    /**
     * 등록된 Udidi 코드 갯수
     */
    @JsonProperty("udidiCount")
    private Integer regUdiCnt;

    /**
     * 수출용 여부
     */
    @JsonProperty("isForExport")
    private Boolean isForExport;

}
