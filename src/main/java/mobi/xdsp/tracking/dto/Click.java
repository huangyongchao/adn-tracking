package mobi.xdsp.tracking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.aerospike.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Indexed;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Data
@Document(collection = "clicks", expiration = 10, expirationUnit = TimeUnit.DAYS)
@AllArgsConstructor
@NoArgsConstructor
public class Click implements Serializable {
    /**
     * 点击ID
     */
    @Id
    private String id;
    /**
     * 渠道id
     */
    private Integer pid;
    /**
     * offerid
     */
    private Integer oid;
    /**
     * 渠道子站
     */
    private String psub;

    /**
     * appid
     */
    private String appid;

    /**
     * idfa
     */
    private String idfa;
    /**
     * gaid
     */
    private String gaid;
    /**
     * 混量子站 null=psub
     */
    private String asub;
    /**
     * 渠道clickid
     */
    private String pclic;
    /**
     * 点击IP
     */
    private String cip;
    /**
     * 点击日期
     */
    private Date ct;

    private String s1;
    private String s2;
    private String s3;


}
