package gov.mfds.example.udi.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 중복된 코드(UDI-DI or 물류바코드) 의 정보
 */
@Getter
@ToString
public class DuplicatedCodeDTO {
    /**
     * 품목허가번호
     */
    @JsonProperty("meddevItemNo")
    private String meddevItemNo;
    /**
     * 형명(모델명)
     */
    @JsonProperty("mebTypeName")
    private String mebTypeName;
}
