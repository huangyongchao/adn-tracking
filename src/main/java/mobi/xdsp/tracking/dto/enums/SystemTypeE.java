package mobi.xdsp.tracking.dto.enums;

/**
 * 系统类型
 *
 * @author huangyongchao
 */
public enum SystemTypeE {

    OLD("old", 0), ADMIN("admin", 1), DSP("dsp", 2);
    public String name;
    public int code;

    private SystemTypeE(String name, int code) {
        this.name = name;
        this.code = code;
    }


}
