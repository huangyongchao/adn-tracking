package mobi.xdsp.tracking.dto.enums;

/**
 * @author huangyongchao
 */
public enum FrequencyTypeE {
    /**
     *
     */
    CONTAINSIDFA("1"), CONVERSIONPERUSER("2");

    public String key;


    private FrequencyTypeE(String key) {
        this.key = key;
    }


}
