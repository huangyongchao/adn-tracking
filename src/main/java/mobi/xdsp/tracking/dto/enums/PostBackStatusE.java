package mobi.xdsp.tracking.dto.enums;

/**
 * @author huangyongchao
 */
public enum PostBackStatusE {
    /**
     * 1:待发送 2:发送成功 3:发送失败 4 不发POSTBACK 不统计报表
     */


    NOSEND(1), SUCCESS(2), FAIL(3), PENDING(4);
    public int code;

    private PostBackStatusE(int code) {
        this.code = code;
    }
}
