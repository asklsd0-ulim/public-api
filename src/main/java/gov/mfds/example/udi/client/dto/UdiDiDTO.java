package gov.mfds.example.udi.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.mfds.example.udi.enums.DiCodeSystem;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class UdiDiDTO {

    /**
     * UDI-DI 일련번호
     */
    @JsonProperty("udiDiSeq")
    private Integer udiDiSeq;

    /**
     * 제품정보
     */
    @JsonProperty("productItemInfo")
    private ProductItemDTO productItem;

    /**
     * 품목일련번호
     */
    @JsonProperty("meddevItemSeq")
    private Integer meddevItemSeq;

    /**
     * 형명(모델)일련번호
     */
    @JsonProperty("mebTypeSeq")
    private Integer mebTypeSeq;

    /**
     * UDI-DI 코드
     */
    @JsonProperty("udiDiCode")
    private String code;

    /**
     * 구분코드 구분
     */
    @JsonProperty("codeSystemFlag")
    private DiCodeSystem codeSystemFlag;

    /**
     * 포장 내 수량
     */
    @JsonProperty("packQuantity")
    private Integer packTotalQty;

    /**
     * 사용종료여부
     */
    @JsonProperty("isUseEnd")
    private Boolean useEndYn;

    /**
     * 사용종료일자
     */
    @JsonProperty("useEndDate")
    private Boolean useEndDate;

    /**
     * 사용종료사유
     */
    @JsonProperty("useEndReason")
    private String useEndReason;

    /**
     * 통합정보 등록 여부
     */
    @JsonProperty("unityInfoRegisted")
    private Boolean unityInfoRegisted;

    /**
     * 통합정보 등록 완료일
     */
    @JsonProperty("unityInfoRegistComptDate")
    private String unityInfoRegistComptDate;

    /**
     * 공급내역여부
     */
    @JsonProperty("isSupplyHist")
    private Boolean supplyHistYn;

    /**
     * 로트번호 사용 여부
     */
    @JsonProperty("useLotNo")
    private Boolean lotNoUseYn;

    /**
     * 일련번호 사용 여부
     */
    @JsonProperty("useItemSeq")
    private Boolean itemSeqUseYn;

    /**
     * 제조연월 사용 여부
     */
    @JsonProperty("useManufYm")
    private Boolean manufYmUseYn;

    /**
     * 사용기한 사용 여부
     */
    @JsonProperty("useTimeLimit")
    private Boolean useTmlmtUseYn;

    /**
     * 멸균의료기기여부
     */
    @JsonProperty("isSterilizationMeddev")
    private Boolean sterilizationMeddevYn;

    /**
     * 사용전 멸균 필요 여부
     */
    @JsonProperty("needSterilization")
    private Boolean befSterilizationNeedYn;

    /**
     * 멸균방법
     */
    @JsonProperty("sterilizationMethods")
    private List<SterilizationMethodDTO> sterilizationMethodInfo;

    /**
     * 요양급여대상여부
     */
    @JsonProperty("isRcperSalaryTarget")
    private Boolean rcperSalaryTargetYn;

    /**
     * 요양급여 정보
     */
    @JsonProperty("rcperSalarys")
    private List<RcperSalaryDTO> rcperSalaryInfo;

    /**
     * 요양급여 코드 미입력 사유
     */
    @JsonProperty("rcperSalaryCodeNoinputReas")
    private String rcperSalaryCodeNoinputReas;

    /**
     * 라텍스 포함 여부
     */
    @JsonProperty("includeLatex")
    private Boolean latexInclsYn;

    /**
     * 프탈레이트 포함 여부
     */
    @JsonProperty("includePhthalate")
    private Boolean phthalateInclsYn;

    /**
     * MRI 안전 노출 여부 코드
     * ('1':안전, '2':안전하지 않음, '3':조건부 안전, '4':평가되지 않음, '5':해당사항 없음)
     */
    @JsonProperty("mriSafeExpsrCode")
    private String mriSafeExpsrCode;

    /**
     * 소프트웨어 버전
     */
    @JsonProperty("swVer")
    private String swVer;

    /**
     * 추가 설명
     */
    @JsonProperty("itemAddDescription")
    private String itemAddDescription;

    /**
     * 비고(치명적인 경고 또는 금기사항)
     */
    @JsonProperty("warnTabooDetail")
    private String warnTabooDetail;

    /**
     * 저장조건
     */
    @JsonProperty("storageCond")
    private String storageCond;

    /**
     * 유통취급조건
     */
    @JsonProperty("distbTreatCond")
    private String distbTreatCond;

    /**
     * 관리책임자 연락처
     */
    @JsonProperty("managerTelNo")
    private String managerChargeTelNo;

    /**
     * 관리책임자 이메일
     */
    @JsonProperty("managerEmail")
    private String managerChargeEmail;

    /**
     * 소비자센터 명칭
     */
    @JsonProperty("consumerStateCenterName")
    private String consumerStateCnterName;

    /**
     * 소비자센터 연락처
     */
    @JsonProperty("consumerStateCnterTelNo")
    private String consumerStateCnterTelNo;

    /**
     * 최초 등록일
     */
    @JsonProperty("registDate")
    private String registDate;
}
