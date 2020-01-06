package gov.mfds.example.udi.enums;

public enum CobFlagCode {
    MNFCTUR("1"), // 제조
    INCME("2"); // 수입

    private String code;

    CobFlagCode(String code) {
        this.code = code;
    }

    public static CobFlagCode of(String cobFlagCode) {
        for (CobFlagCode value : values()) {
            if (value.code.equals(cobFlagCode)) {
                return value;
            }
        }
        if ("제조".equals(cobFlagCode)) {
            return MNFCTUR;
        }
        if ("수입".equals(cobFlagCode)) {
            return INCME;
        }
        return null;
    }

    public String getCode() {
        return code;
    }
}
