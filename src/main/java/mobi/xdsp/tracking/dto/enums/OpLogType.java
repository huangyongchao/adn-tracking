package mobi.xdsp.tracking.dto.enums;

public enum OpLogType {

    UNCHANGE("unchange",0),

    INCREMENT("increment", 1), //增加投放量

    DECREMENT("decrement", 2),  //较少投放量

    OPENOFFER("openoffer", 3),  //开单

    STOPOFFER("stopoffer", 4);  //停单

    public String type;

    public int code;

    private OpLogType(String type, int code) {
        this.type = type;
        this.code = code;
    }
}
