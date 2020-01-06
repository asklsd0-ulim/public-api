package gov.mfds.example.udi.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Getter
@ToString
@Slf4j
public class UpdateUdiDiUnityInfoDTO {

    /**
     * 멸균방법
     */
    @Getter
    @Setter
    @ToString
    public static class SterilizationMethod {

        /**
         * 순번
         */
        @JsonProperty("order")
        private Integer order;

        /**
         * 멸균방법 코드
         */
        @JsonProperty("code")
        private String sterilizationMethodCode = "";

        /**
         * 멸균방법
         */
        @JsonProperty("name")
        private String sterilizationMethodName = "";

        /**
         * 기타멸균방법
         */
        @JsonProperty("etc")
        private String etcSterilizationMethod = "";

    }

    /**
     * 요양급여
     */
    @Getter
    @Setter
    @ToString
    public static class RcperSalary {
        /**
         * 순번
         */
        @JsonProperty("order")
        private Integer order;

        /**
         * 요양급여 재료대 코드
         */
        @JsonProperty("code")
        private String rcperSalaryCode = "";

        /**
         * 요양급여_재료대_품목명
         */
        @JsonProperty("name")
        private String rcperSalaryItemName = "";


        /**
         * 요양급여_치료_재료대_중분류_명
         */
        @JsonProperty("mlsfcName")
        private String rcperSalaryMlsfcName = "";

    }

    /**
     * 포장 내 수량
     */
    @JsonProperty("packQantity")
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
    private String useEndDate;

    /**
     * 사용종료사유
     */
    @JsonProperty("useEndReason")
    private String useEndReason;

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
    private List<SterilizationMethod> sterilizationMethodInfo;

    /**
     * 요양급여대상여부
     */
    @JsonProperty("isRcperSalaryTarget")
    private Boolean rcperSalaryTargetYn;

    /**
     * 요양급여 정보
     */
    @JsonProperty("rcperSalarys")
    private List<RcperSalary> rcperSalaryInfo;

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
    @JsonProperty("consumerStateCenterTelNo")
    private String consumerStateCnterTelNo;
}
