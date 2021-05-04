package mobi.xdsp.tracking.dto.enums;

/**
 * dsp 素材来源类型
 *
 * @author huangyongchao
 * video  0  local  video
 * video  -1  local rewarded video
 * banner  0   web url image
 * banner  >0  local image
 */
public enum VideoResourceE {

    VIDEO("video", 0),  REWARDEDVIDEO("rewardedvideo", -1);
    public String name;
    public int code;

    private VideoResourceE(String name, int code) {
        this.name = name;
        this.code = code;
    }


}
