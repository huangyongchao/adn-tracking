package mobi.xdsp.tracking.dto.enums;

/**
 * dsp activeReport报表
 * 与logTracker报表的枚举
 *
 *
 * @author huangyongchao
 */
public enum ReportFlagE {

    ACTIVEREPORT("activereport", 1), LOGTRACKER("logtracker", 2);
    public String name;
    public int code;

    private ReportFlagE(String name, int code) {
        this.name = name;
        this.code = code;
    }
}
