package mobi.xdsp.tracking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import mobi.xdsp.tracking.common.DateTimeUtil;
import org.springframework.data.aerospike.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Indexed;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Data
@Document(collection = "clicks", expiration = 8, expirationUnit = TimeUnit.DAYS)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Click implements Serializable {
    private boolean fullClick = false;
    /**
     * 点击ID
     */
    @Id
    private String id;
    /**
     * 渠道id
     */
    private Integer pid = 0;
    /**
     * offerid
     */
    private Integer oid;
    /**
     * 渠道子站
     */
    private String pubSub = "";

    /**
     * appid
     */
    private String appId = "";

    /**
     * idfa
     */
    private String idfa = "";
    /**
     * gaid
     */
    private String gaid = "";
    /**
     * 混量子站 null=psub
     */
    private String mixSub = "";
    /**
     * 渠道clickid
     */
    private String clickId = "";
    /**
     * 点击IP
     */
    private String cip = "";
    /**
     * 点击日期
     */
    private Date ct;

    private String s1 = "";
    private String s2 = "";

    private String ip = "";
    private String lang = "";
    @Transient
    private String ua = "";
    private String appN = "";
    /**
     * 自动重定向流量. 转化不下发
     */
    private boolean isr;
    /**
     * 重定向offerid
     */
    private Integer roid;
    @Transient
    private String link;
    /**
     * source off id
     */
    private String soid;


    private DeviceInfo deviceInfo = new DeviceInfo();


    @Override
    public String toString() {
        return "Click{" +
                "id='" + id + '\'' +
                ", pid=" + pid +
                ", oid=" + oid +
                ", pubSub='" + pubSub + '\'' +
                ", appId='" + appId + '\'' +
                ", idfa='" + idfa + '\'' +
                ", gaid='" + gaid + '\'' +
                ", mixSub='" + mixSub + '\'' +
                ", clickId='" + clickId + '\'' +
                ", cip='" + cip + '\'' +
                ", ct=" + DateTimeUtil.getStringDate() +
                ", s1='" + s1 + '\'' +
                ", s2='" + s2 + '\'' +
                ", ip='" + ip + '\'' +
                ", lang='" + lang + '\'' +
                ", ua='" + ua + '\'' +
                ", appN='" + appN + '\'' +
                ", isr=" + isr +
                ", roid=" + roid +
                ", link='" + link + '\'' +
                '}';
    }
}
