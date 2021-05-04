package mobi.xdsp.tracking.dto.enums;

public enum BlackListTypeEnum {
    /*1 黑  2 白*/
    BLACK("black", new Byte("1")), WHITE("white", new Byte("2")), NORMAL("normal", new Byte("3")), MIX("mix", new Byte("4"));

    private String name;
    private Byte code;

    private BlackListTypeEnum(String name, Byte code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getCode() {
        return code;
    }

    public void setCode(Byte code) {
        this.code = code;
    }
}
