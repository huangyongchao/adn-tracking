package mobi.xdsp.tracking.dto.enums;

/**
 * @author huangyongchao
 * Native 里的context类型
 * 10 General or mixed content. 普通的feed流式 ,比如新闻APP的推送条目
 * 11 Primarily article content (which of course could include images, etc as part of the article) 文章列表
 * 12 Primarily video content 视频类的feed
 * 13 Primarily audio content 音频
 * 14 Primarily image content 图片
 * 15 User-generated content - forums, comments, etc  评论类的推送条目
 * 20 General social content such as a general social network 普通社交格式
 * 21 Primarily email content  email社交广告
 * 22 Primarily chat/IM content  IM社交广告
 * 30 Content focused on selling products, whether digital or physical  普通的购物网站的实体商品列表
 * 31 Application store/marketplace  APP store 的app商品列表
 * 32 Product reviews site primarily (which may sell product secondarily) 点评类的商品列表
 */
public enum NativeContextSubTypeIDsE {
    /**
     *
     */
    FEED_GENERAL("10"),
    FEED_ARTICLE("11"),
    FEED_VIDEO("12"),
    FEED_AUDIO("13"),
    FEED_IMAGEL("14"),
    FEED_FORUMS("15"),
    SOCIAL_GENERAL("20"),
    SOCIAL_EMAIL("21"),
    SOCIAL_CHATIM("22"),
    ASPRODUCT_GENERAL("30"),
    ASPRODUCT_APP("31"),
    ASPRODUCT_REVIEWS("32");

    public String code;

    private NativeContextSubTypeIDsE(String code) {
        this.code = code;
    }


}
