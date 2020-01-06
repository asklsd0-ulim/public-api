package gov.mfds.example.udi.enums;

// (1:GS1, 2:HIBCC, 3:ICCBBA)
public enum DiCodeSystem {
    GS1("1"), HIBICC("2"), ICCBBA("3");

    private final String flag;

    DiCodeSystem(String flag) {
        this.flag = flag;
    }

    public String getValue() {
        return flag;
    }

    public static DiCodeSystem of(String flag) {
        for (DiCodeSystem value : DiCodeSystem.values()) {
            if (value.flag.equals(flag)) {
                return value;
            }
        }

        return null;
    }

}
