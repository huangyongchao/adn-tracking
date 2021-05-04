package mobi.xdsp.tracking.dto.enums;

/**
 * 系统类型
 *
 * @author huangyongchao
 */
public enum ResourceTypeE {

    MENU("menu", 1), BUTTON("button", 2), API("api", 3);
    public String name;
    public int code;

    private ResourceTypeE(String name, int code) {
        this.name = name;
        this.code = code;
    }


}
