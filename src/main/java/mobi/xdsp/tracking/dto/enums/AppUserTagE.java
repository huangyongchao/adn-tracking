package mobi.xdsp.tracking.dto.enums;

/**
 * @author huangyongchao
 * 将媒体APP的用户人群进行标签化 U开头
 */
public enum AppUserTagE {
    /**
     * male 男性 , female 女性, gay 同性 , infant mom  孕妇  ,kids 孩子 ,student  学生 ,youth 青年 ,middle 中年,
     * senior 年长 , patient 病人 ,handcapped 残疾
     */
    MALE("u1"),
    FEMALE("u2"),
    GAY("u3"),
    INFANTMOM("u4"),
    KIDS("u5"),
    STUDENT("u6"),
    YOUTH("u7"),
    MIDDLE("u8"),
    SENIOR("u9"),
    PATIENT("u10"),
    HANDICAPPED("u11");

    public String code;

    private AppUserTagE(String code) {
        this.code = code;
    }

}
