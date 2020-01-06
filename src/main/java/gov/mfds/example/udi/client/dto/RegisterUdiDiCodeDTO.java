package gov.mfds.example.udi.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.mfds.example.udi.enums.DiCodeSystem;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class RegisterUdiDiCodeDTO {
    /**
     * 품목일련번호
     */
    @JsonProperty("meddevItemSeq")
    private Integer meddevItemSeq;
    /**
     * 형명(모델명)
     */
    @JsonProperty("mebTypeName")
    private String mebTypeName;
    /**
     * 코드검증 및 중복검사 완료된 UDI-DI코드
     */
    @JsonProperty("udiDiCode")
    private String udiDiCode;
    /**
     * 코드구분
     */
    @JsonProperty("codeSystem")
    private DiCodeSystem codeSystem;
    /**
     * 수출용 여부
     */
    @JsonProperty("isForExport")
    private Boolean isForExport;


}
