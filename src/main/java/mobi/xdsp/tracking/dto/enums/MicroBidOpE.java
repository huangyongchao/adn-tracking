package mobi.xdsp.tracking.dto.enums;

/**
 * dsp 规则引擎的规则应用类型
 * @author huangyongchao
 * 1 increase
 * 2 decrease
 */
public enum MicroBidOpE {

    INCREASE("increase", 1),  DECREASE("decrease", 2);
    public String name;
    public int code;

    private MicroBidOpE(String name, int code) {
        this.name = name;
        this.code = code;
    }


}
