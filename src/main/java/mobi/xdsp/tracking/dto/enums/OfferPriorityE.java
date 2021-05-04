package mobi.xdsp.tracking.dto.enums;

/**
 * @author huangyongchao
 */
public enum OfferPriorityE {
    /**
     * 1  不投放
     * 2  自动脚本开的投放
     * 3  运营手动开的投放
     * 4  业绩波动 待观察
     * 5  重点offer 特殊关照
     */
    STOP(1), AUTORUN(2), RUN(3), OBSERVED(4), IMPORTANT(5);
    public Integer code;

    private OfferPriorityE(Integer code) {
        this.code = code;
    }
}
