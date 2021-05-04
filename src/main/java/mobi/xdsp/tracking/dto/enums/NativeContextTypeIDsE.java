package mobi.xdsp.tracking.dto.enums;

/**
 * @author huangyongchao
 * Native 里的context类型
 * FEED 指的是 Content-centric context such as newsfeed, article, image gallery, video gallery, or similar.
 * SOCIAL  Social-centric context such as social network feed, email, chat, or similar
 * ASPRODUCT Product context such as product listings, details, recommendations, reviews, or similar.
 */
public enum NativeContextTypeIDsE {
    /**
     *
     */
    FEED(1), SOCIAL(2),ASPRODUCT(3);

    public int code;

    private NativeContextTypeIDsE(int code) {
        this.code = code;
    }


}
