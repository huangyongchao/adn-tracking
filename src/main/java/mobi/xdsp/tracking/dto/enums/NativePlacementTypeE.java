package mobi.xdsp.tracking.dto.enums;

/**
 * @author huangyongchao
 * Native 里的 Asset IMage Type
 */
public enum NativePlacementTypeE {
    /**
     *FEED 就是主流的 新闻啊 商品啊 等列表样式 feed样式  网格样式 或者 轮播样式
     * In the feed of content - for example as an item inside the organic feed/grid/listing/carousel.
     * ATOMIC_UNIT 就是单一内容比如文章内部的一段广告
     * In the atomic unit of the content - IE in the article page or single image page
     * OUTSIDE 比如在文章或者内容周边的比如左边 或者右边的栏目
     * Outside the core content - for example in the ads section on the right rail, as a banner-style placement near the content, etc.
     * RECOMMENDATION 就是推荐栏儿的广告 比如商品推荐，视频或者图片或者阅读推荐等
     * Recommendation widget, most commonly presented below the article content.
     *
     */
    FEED(1), ATOMIC_UNIT(2), OUTSIDE(3), RECOMMENDATION(4);

    public int code;

    private NativePlacementTypeE(int code) {
        this.code = code;
    }


}
