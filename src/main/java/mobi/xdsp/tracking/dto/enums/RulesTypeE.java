package mobi.xdsp.tracking.dto.enums;

/**
 * dsp 规则引擎的规则应用类型
 * @author huangyongchao
 * 1 publisher
 * 2 app
 * 3 creative
 * 4 country
 * 5 carrier
 */
public enum RulesTypeE {

    PUBLISHER("publisher", 1),  APP("app", 2),  CREATIVE("creative", 3),  COUNTRY("country", 4),  CARRIER("carrier", 5);
    public String name;
    public int code;

    private RulesTypeE(String name, int code) {
        this.name = name;
        this.code = code;
    }


}
