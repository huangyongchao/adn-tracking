package mobi.xdsp.tracking.dto.enums;

/**
 * dsp Microbid 来源
 * @author huangyongchao
 * 1  手动建立
 * 2  报表添加
 * 3  rules计算产生
 */
public enum MicroBidResourceE {

    MANUAL("manual", 1),  REPORT("report", 2),  RULES("rules", 3);
    public String name;
    public int code;

    private MicroBidResourceE(String name, int code) {
        this.name = name;
        this.code = code;
    }


}
