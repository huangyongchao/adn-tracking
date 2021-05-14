package mobi.xdsp.tracking.entity;

public class ActivateWithBLOBs extends Activate {
    private String clickid;

    private String clickidext;

    private String affsub1;

    private String affsub2;

    private String affsub3;


    public String getClickid() {
        return clickid;
    }

    public void setClickid(String clickid) {
        this.clickid = clickid == null ? null : clickid.trim();
    }

    public String getClickidext() {
        return clickidext;
    }

    public void setClickidext(String clickidext) {
        this.clickidext = clickidext == null ? null : clickidext.trim();
    }

    public String getAffsub1() {
        return affsub1;
    }

    public void setAffsub1(String affsub1) {
        this.affsub1 = affsub1 == null ? null : affsub1.trim();
    }

    public String getAffsub2() {
        return affsub2;
    }

    public void setAffsub2(String affsub2) {
        this.affsub2 = affsub2 == null ? null : affsub2.trim();
    }

    public String getAffsub3() {
        return affsub3;
    }

    public void setAffsub3(String affsub3) {
        this.affsub3 = affsub3 == null ? null : affsub3.trim();
    }
}