package mobi.xdsp.tracking.dto.enums;

/**
 * dsp query conditions
 * @author tonyhongshuo
 */
public enum QueryConditionsE {
    /**
     *
     */
    EqualTo(1,"="),
    /**
     *
     */
    GreaterThan(2,">"),
    /**
     *
     */
    LessThan(3,"<"),
    /**
     *
     */
    NotEqualTo( 4,"!="),
    /**
     *
     */
    GreaterThanEqualTo( 5,">="),
    /**
     *
     */
    LessThanEqualTo(6,"<="),
    ;


    private String  value;
    private Integer code;

  private  QueryConditionsE( Integer code,String value) {
        this.value = value;
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
