package mobi.xdsp.tracking.dto.enums;

/**
 * @author huangyongchao
 * Native 里的 Asset  Type
 */
public enum NativeDataAssetTypeE {
    /**
     */
    SPONSORED("sponsored",1), DESC("desc",2), RATING("rating",3), LIKES("likes",4),
    DOWNLOADS("downloads",5), PRICE("price",6), SALEPRICE("saleprice",7), PHONE("phone",8),
    ADDRESS("address",9), DESC2("desc2",10), DISPLAYURL("displayurl",11), CTATEXT("ctatext",12);

    public int code;
    public String type;

    private NativeDataAssetTypeE(String type, int code) {
        this.code = code;
        this.type = type;
    }

}
