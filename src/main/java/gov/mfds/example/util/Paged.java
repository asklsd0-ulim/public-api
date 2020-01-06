package gov.mfds.example.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class Paged<T> {
    @JsonProperty("totalElements")
    private Integer totalElements;
    @JsonProperty("page")
    private Integer page;
    @JsonProperty("pageSize")
    private Integer pageSize;
    @JsonProperty("items")
    private List<T> items;
}
