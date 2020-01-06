package gov.mfds.example.udi.client.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class DeleteUdiDiCodeDTO {
    private Integer meddevItemSeq;
    private Integer mebTypeSeq;
    private Integer udiDiSeq;

    public DeleteUdiDiCodeDTO(Integer meddevItemSeq, Integer mebTypeSeq, Integer udiDiSeq) {
        this.meddevItemSeq = meddevItemSeq;
        this.mebTypeSeq = mebTypeSeq;
        this.udiDiSeq = udiDiSeq;
    }
}
