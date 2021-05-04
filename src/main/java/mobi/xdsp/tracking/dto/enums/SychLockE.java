package mobi.xdsp.tracking.dto.enums;

/**
 * 数据同步状态
 *
 * @author huangyongchao
 */
public enum SychLockE {
    /**
     * 未同步 NONE
     * 同步中 TAKING
     * 同步完  LOCKED
     * 只有同步完的数据 才可以跳转.
     * 同步后的数据在判断状态
     * <p>
     * 同步后的在定期同步 缓存CACHE
     */
    NONE(0), TAKING(1), LOCKED(2);
    public int code;

    private SychLockE(int code) {
        this.code = code;
    }
}
