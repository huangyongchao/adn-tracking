package mobi.xdsp.tracking.dto.enums;

/**
 *
 * @author huangyongchao
 */
public enum UserTypeE {
    /**
     */
    SYS("sys", 1), PUBLISHER("publisher", 2);
    public String name;
    public int code;

    private UserTypeE(String name, int code) {
        this.name = name;
        this.code = code;
    }
}
