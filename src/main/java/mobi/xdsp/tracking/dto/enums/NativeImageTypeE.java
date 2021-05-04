package mobi.xdsp.tracking.dto.enums;

/**
 * @author huangyongchao
 * Native 里的 Asset IMage Type
 */
public enum NativeImageTypeE {
    /**
     *
     */
    ICON("icon",1), LOGO("logo",2), MAIN("main",3), VIDEO("video",500);

    public int code;
    public String type;

    private NativeImageTypeE(String type, int code) {
        this.code = code;
        this.type = type;
    }


}
