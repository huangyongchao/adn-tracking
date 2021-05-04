package mobi.xdsp.tracking.dto.enums;

/**
 *
 * @author huangyongchao
 */
public enum OrderStatusE {
    /**
     * 1:new 2:invalid 3:commission 4 不发POSTBACK 不统计报表
     */


    NEWORDER(1), INVALID(2), COMMISSION(3), PENDING(4), DEDUCTION(5);
    public int code;

    private OrderStatusE(int code) {
        this.code = code;
    }
}
