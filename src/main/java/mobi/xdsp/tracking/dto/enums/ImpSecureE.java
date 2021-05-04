package mobi.xdsp.tracking.dto.enums;

public enum ImpSecureE {


    NONSECURE("http://", 0),
    SECURE("https://", 1);
    public String name;
    public int code;

    private ImpSecureE(String name, int code) {
        this.name = name;
        this.code = code;
    }


}
