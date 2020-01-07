package gov.mfds.example.udi.client;

import gov.mfds.example.udi.client.dto.*;
import gov.mfds.example.udi.enums.CobFlagCode;
import gov.mfds.example.udi.enums.DiCodeSystem;
import gov.mfds.example.util.Paged;
import gov.mfds.example.util.PublicApiRestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static java.lang.String.format;

@Component
@Slf4j
public class UDIClient {
    private PublicApiRestTemplate restTemplate;

    @Autowired
    public UDIClient(PublicApiRestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Paged<ProductModelDTO> getModels(String searchKeyword,
                                            Integer offset,
                                            Integer limit) {
        String uri = "/api/v1/int-info/models";
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("offset", offset);
        param.add("limit", limit);
        param.add("modelNameLike", searchKeyword);
        ResponseEntity<Paged<ProductModelDTO>> responseEntity =
                restTemplate.getList(uri, param, ProductModelDTO.class);
        Paged<ProductModelDTO> list = responseEntity.getBody();
        return list;
    }

    public Paged<ProductItemDTO> getItems(ItemsQueryDTO queryDTO) {
        String uri = "/api/v1/int-info/items";
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("offset", queryDTO.getOffset());
        param.add("limit", queryDTO.getLimit());
        param.add("searchItemName", queryDTO.getSearchItemName());
        param.add("searchProductName", queryDTO.getSearchProductName());
        param.add("searchGrade", queryDTO.getSearchGrade());
        param.add("searchStartDate", queryDTO.getSearchStartDate());
        param.add("searchEndDate", queryDTO.getSearchEndDate());
        param.add("searchUdiDiCode", queryDTO.getSearchUdiDiCode());
        ResponseEntity<Paged<ProductItemDTO>> responseEntity =
                restTemplate.getList(uri, param, ProductItemDTO.class);
        return responseEntity.getBody();
    }

    public Paged<UdiDiDTO> getUdiDis(Integer meddevItemSeq, String mebTypeName, boolean isForExport) {
        String uri = "/api/v1/int-info/udidi-unity";
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("meddevItemSeq", meddevItemSeq);
        param.add("mebTypeName", mebTypeName.replace("+", "%2B").replace("&", "%26"));
        param.add("isForExport", isForExport);
        ResponseEntity<Paged<UdiDiDTO>> responseEntity = restTemplate.getList(uri, param, UdiDiDTO.class);
        Paged<UdiDiDTO> udiDiDTO = responseEntity.getBody();
        return udiDiDTO;
    }

    public Integer registUdiDiCode(RegisterUdiDiCodeDTO registerUdiDiCodeDTO) {
        String uri = "/api/test/v1/int-info/udidi-unity";
        ResponseEntity<Integer> responseEntity = restTemplate.post(uri, registerUdiDiCodeDTO, Integer.class);
        Integer newUdiDiCodeKey = responseEntity.getBody();
        return newUdiDiCodeKey;
    }

    public DuplicatedCodeDTO getUdiCode(String udiCode, DiCodeSystem codeSystem, CobFlagCode cobFlagCode) {
        String uri = "/api/v1/int-info/udidi-code";
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("udiDiCode", udiCode);
        param.add("codeSystem", codeSystem.name());
        param.add("cobFlagCode", cobFlagCode.name());
        ResponseEntity<DuplicatedCodeDTO> responseEntity =
                restTemplate.get(uri, param, DuplicatedCodeDTO.class);
        if (responseEntity.getStatusCode() == HttpStatus.NO_CONTENT) {
            return null;
        }

        return responseEntity.getBody();
    }

    public UdiDiDTO updateUnityinfo(Integer meddevItemSeq, Integer mebTypeSeq, Integer udiDiSeq,
                                UpdateUdiDiUnityInfoDTO dto) {
        String uri = format("/api/v1/int-info/udidi-unity/%d/%d/%d",
                meddevItemSeq, mebTypeSeq, udiDiSeq);

        ResponseEntity<UdiDiDTO> responseEntity = restTemplate.post(uri, dto, UdiDiDTO.class);

        return responseEntity.getBody();
    }

    public void deleteUdiDiCode(DeleteUdiDiCodeDTO deleteUdiDiCodeDTO) {
        String uri = format("/api/v1/int-info/udidi-code/%d/%d/%d",
                deleteUdiDiCodeDTO.getMeddevItemSeq(),
                deleteUdiDiCodeDTO.getMebTypeSeq(),
                deleteUdiDiCodeDTO.getUdiDiSeq());
        ResponseEntity<Void> responseEntity = restTemplate.post(uri, null, Void.class);
        if (responseEntity.getStatusCodeValue() != 200) {
            throw new IllegalStateException();
        }
    }

    public Paged<UdiDiBarcodeDTO> getBarcodes(Integer meddevItemSeq, Integer mebTypeSeq, Integer udiDiSeq) {
        String uri = format("/api/v1/int-info/udidi-unity/%d/%d/%d/barcodes",
                meddevItemSeq, mebTypeSeq, udiDiSeq);
        ResponseEntity<Paged<UdiDiBarcodeDTO>> responseEntity = restTemplate.getList(uri, new LinkedMultiValueMap<>(), UdiDiBarcodeDTO.class);

        return responseEntity.getBody();
    }

    public UdiDiBarcodeDTO addBarcode(Integer meddevItemSeq, Integer mebTypeSeq, Integer udiDiSeq,
                                      AddUdiDiBarcodeDTO barcodeDTO) {
        String uri = format("/api/v1/int-info/udidi-unity/%d/%d/%d/barcodes",
                meddevItemSeq, mebTypeSeq, udiDiSeq);

        ResponseEntity<UdiDiBarcodeDTO> responseEntity = restTemplate.post(uri, barcodeDTO, UdiDiBarcodeDTO.class);

        return responseEntity.getBody();
    }

    public UdiDiBarcodeDTO updateBarcode(Integer meddevItemSeq, Integer mebTypeSeq, Integer udiDiSeq,
                                         Integer barcodeSeq,
                                         UpdateUdiDiBarcodeDTO barcodeDTO) {
        String uri = format("/api/v1/int-info/udidi-unity/%d/%d/%d/barcodes/%d",
                meddevItemSeq, mebTypeSeq, udiDiSeq, barcodeSeq);

        ResponseEntity<UdiDiBarcodeDTO> responseEntity = restTemplate.post(uri, barcodeDTO, UdiDiBarcodeDTO.class);

        return responseEntity.getBody();
    }

    public void deleteBarcode(Integer meddevItemSeq, Integer mebTypeSeq, Integer udiDiSeq,
                              Integer barcodeSeq) {
        String uri = format("/api/v1/int-info/udidi-unity/%d/%d/%d/barcodes/%d/delete",
                meddevItemSeq, mebTypeSeq, udiDiSeq, barcodeSeq);

        ResponseEntity<Void> responseEntity = restTemplate.post(uri, null, Void.class);
        if (responseEntity.getStatusCodeValue() != 200) {
            throw new IllegalStateException();
        }
    }

    public RcperSalaryDTO findRcperSalary(String rcperSalaryCode) {
        String url = format("/rcper-salary/%s", rcperSalaryCode);
        ResponseEntity<RcperSalaryDTO> responseEntity = restTemplate.get(url, new LinkedMultiValueMap<>(), RcperSalaryDTO.class);
        return responseEntity.getBody();
    }
}
