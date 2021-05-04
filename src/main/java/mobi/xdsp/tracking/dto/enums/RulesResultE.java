package mobi.xdsp.tracking.dto.enums;

/**
 * dsp 规则引擎的规则应用类型
 * @author huangyongchao
 * 1 Exclude from  Campaigns Targeting
 * 2 Deactive Campaigns
 * 3 Set a Micro bidding
 */
public enum RulesResultE {

    EXCLUDE("exclude", 1),  DEACTIVE("deactive", 2),  MICROBIDDING("microbidding", 3);
    public String name;
    public int code;

    private RulesResultE(String name, int code) {
        this.name = name;
        this.code = code;
    }


}
