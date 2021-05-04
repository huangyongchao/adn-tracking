package mobi.xdsp.tracking.dto.enums;

public enum VideoApiE {

    VPAID1("VPAID1", 1),
    VPAID2("VPAID2", 2),
    MRAID("MRAID", 3),
    ORMMA("ORMMA", 4),
    MRAID2("MRAID2", 5),
    MRAID3("MRAID3", 6);
    public String name;
    public int code;

    private VideoApiE(String name, int code) {
        this.name = name;
        this.code = code;
    }


}
