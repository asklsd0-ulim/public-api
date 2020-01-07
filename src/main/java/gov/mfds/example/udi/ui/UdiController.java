package gov.mfds.example.udi.ui;

import gov.mfds.example.udi.client.UDIClient;
import gov.mfds.example.udi.client.dto.*;
import gov.mfds.example.udi.enums.CobFlagCode;
import gov.mfds.example.udi.enums.DiCodeSystem;
import gov.mfds.example.util.Paged;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class UdiController {

    private UDIClient udiClient;

    @Autowired
    public UdiController(UDIClient udiClient) {
        this.udiClient = udiClient;
    }

    @GetMapping("/models")
    public String modelList(@RequestParam Map<String, String> param, ModelMap modelMap) {
        if (!param.containsKey("searchKeyword")) {
            return "modelList";
        }
        Paged<ProductModelDTO> models = udiClient.getModels(
                param.get("searchKeyword"),
                Integer.parseInt(param.getOrDefault("offset", "1")),
                Integer.parseInt(param.getOrDefault("limit", "10")));
        modelMap.put("models", models);
        return "modelList";
    }

    @GetMapping("/udi")
    @ResponseBody
    public Paged<UdiDiDTO> udiList(@RequestParam Map<String, String> param, ModelMap modelMap) {
        Paged<UdiDiDTO> udiDis = udiClient.getUdiDis(Integer.parseInt(param.get("meddevItemSeq")),
                param.get("mebTypeName"),
                Boolean.parseBoolean(param.get("isForExport")));
        return udiDis;
    }

    @PostMapping("/udi")
    @ResponseBody
    public ResponseEntity registerUdiDiCode(@RequestBody RegisterUdiDiCodeDTO dto, ModelMap modelMap) {
        Integer udiDiSeq = udiClient.registUdiDiCode(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/udi/code")
    public ResponseEntity<DuplicatedCodeDTO> checkDuplicateCode(@RequestParam("udiDiCode") String code,
                                                                @RequestParam("codeSystem")DiCodeSystem codeSystem,
                                                                @RequestParam("cobFlagCode")CobFlagCode cobFlagCode) {
        return ResponseEntity.ok(udiClient.getUdiCode(code, codeSystem, cobFlagCode));
    }

    @PostMapping("/udi/delete")
    @ResponseBody
    public ResponseEntity deleteUdiDiCode(@RequestBody DeleteUdiDiCodeDTO dto, ModelMap modelMap) {
        udiClient.deleteUdiDiCode(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/barcodes")
    @ResponseBody
    public List<UdiDiBarcodeDTO> getBarcodes(@RequestParam("meddevItemSeq") Integer meddevItemSeq,
                                             @RequestParam("mebTypeSeq") Integer mebTypeSeq,
                                             @RequestParam("udiDiSeq") Integer udiDiSeq) {
        Paged<UdiDiBarcodeDTO> barcodes = udiClient.getBarcodes(meddevItemSeq, mebTypeSeq, udiDiSeq);
        return barcodes.getItems();
    }

    @PostMapping("/barcodes/{meddevItemSeq}/{mebTypeSeq}/{udiDiSeq}")
    @ResponseBody
    public UdiDiBarcodeDTO addBarcode(@PathVariable("meddevItemSeq") Integer meddevItemSeq,
                             @PathVariable("mebTypeSeq") Integer mebTypeSeq,
                             @PathVariable("udiDiSeq") Integer udiDiSeq,
                             @RequestBody AddUdiDiBarcodeDTO dto) {
        UdiDiBarcodeDTO udiDiBarcodeDTO = udiClient.addBarcode(meddevItemSeq, mebTypeSeq, udiDiSeq, dto);
        return udiDiBarcodeDTO;
    }

    @PostMapping("/barcodes/{meddevItemSeq}/{mebTypeSeq}/{udiDiSeq}/{barcodeSeq}")
    @ResponseBody
    public UdiDiBarcodeDTO updateBarcode(@PathVariable("meddevItemSeq") Integer meddevItemSeq,
                                @PathVariable("mebTypeSeq") Integer mebTypeSeq,
                                @PathVariable("udiDiSeq") Integer udiDiSeq,
                                @PathVariable("barcodeSeq") Integer barcodeSeq,
                                @RequestBody UpdateUdiDiBarcodeDTO dto, ModelMap modelMap) {
        UdiDiBarcodeDTO udiDiBarcodeDTO = udiClient.updateBarcode(meddevItemSeq, mebTypeSeq,
                udiDiSeq, barcodeSeq, dto);

        return udiDiBarcodeDTO;
    }

    @PostMapping("/barcodes/{meddevItemSeq}/{mebTypeSeq}/{udiDiSeq}/{barcodeSeq}/delete")
    @ResponseBody
    public ResponseEntity deleteBarcode(@PathVariable("meddevItemSeq") Integer meddevItemSeq,
                                @PathVariable("mebTypeSeq") Integer mebTypeSeq,
                                @PathVariable("udiDiSeq") Integer udiDiSeq,
                                @PathVariable("barcodeSeq") Integer barcodeSeq,
                                ModelMap modelMap) {
        udiClient.deleteBarcode(meddevItemSeq, mebTypeSeq, udiDiSeq, barcodeSeq);
        return ResponseEntity.ok().build();
    }
}
