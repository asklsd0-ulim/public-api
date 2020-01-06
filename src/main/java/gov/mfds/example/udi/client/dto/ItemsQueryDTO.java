package gov.mfds.example.udi.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ItemsQueryDTO {
    @JsonProperty("offset")
    private Integer offset = 0;
    @JsonProperty("limit")
    private Integer limit = 10;
    @JsonProperty("searchItemName")
    private String searchItemName;
    @JsonProperty("searchProductName")
    private String searchProductName;
    @JsonProperty("searchGrade")
    private String searchGrade;
    @JsonProperty("searchStartDate")
    private String searchStartDate;
    @JsonProperty("searchEndDate")
    private String searchEndDate;
    @JsonProperty("searchUdiDiCode")
    private String searchUdiDiCode;
}
