package mobi.xdsp.tracking.dto.enums;

/**
 * @author huangyongchao
 */
public enum PostbackTypeE {

    GLOBAL("global", 1), EVENT("event", 2);
    public String name;
    public int code;

    private PostbackTypeE(String name, int code) {
        this.name = name;
        this.code = code;
    }
}
