package mobi.xdsp.tracking.entity;

public class OfferConf {
    private Integer id;

    private Integer p360;

    private Integer strongkpi;

    private Integer autoblack;

    private Integer autoredirect;

    private String blackpub;

    private String whitepub;

    private String convertionflow;

    private String event1;

    private Float event1payout;

    private String event2;

    private Float event2payout;

    private Integer singular;

    private String mutigeo;

    private String mutios;

    private String targetcity;

    private Integer ios14params;

    private Integer deleteflag;

    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getP360() {
        return p360;
    }

    public void setP360(Integer p360) {
        this.p360 = p360;
    }

    public Integer getStrongkpi() {
        return strongkpi;
    }

    public void setStrongkpi(Integer strongkpi) {
        this.strongkpi = strongkpi;
    }

    public Integer getAutoblack() {
        return autoblack;
    }

    public void setAutoblack(Integer autoblack) {
        this.autoblack = autoblack;
    }

    public Integer getAutoredirect() {
        return autoredirect;
    }

    public void setAutoredirect(Integer autoredirect) {
        this.autoredirect = autoredirect;
    }

    public String getBlackpub() {
        return blackpub;
    }

    public void setBlackpub(String blackpub) {
        this.blackpub = blackpub == null ? null : blackpub.trim();
    }

    public String getWhitepub() {
        return whitepub;
    }

    public void setWhitepub(String whitepub) {
        this.whitepub = whitepub == null ? null : whitepub.trim();
    }

    public String getConvertionflow() {
        return convertionflow;
    }

    public void setConvertionflow(String convertionflow) {
        this.convertionflow = convertionflow == null ? null : convertionflow.trim();
    }

    public String getEvent1() {
        return event1;
    }

    public void setEvent1(String event1) {
        this.event1 = event1 == null ? null : event1.trim();
    }

    public Float getEvent1payout() {
        return event1payout;
    }

    public void setEvent1payout(Float event1payout) {
        this.event1payout = event1payout;
    }

    public String getEvent2() {
        return event2;
    }

    public void setEvent2(String event2) {
        this.event2 = event2 == null ? null : event2.trim();
    }

    public Float getEvent2payout() {
        return event2payout;
    }

    public void setEvent2payout(Float event2payout) {
        this.event2payout = event2payout;
    }

    public Integer getSingular() {
        return singular;
    }

    public void setSingular(Integer singular) {
        this.singular = singular;
    }

    public String getMutigeo() {
        return mutigeo;
    }

    public void setMutigeo(String mutigeo) {
        this.mutigeo = mutigeo == null ? null : mutigeo.trim();
    }

    public String getMutios() {
        return mutios;
    }

    public void setMutios(String mutios) {
        this.mutios = mutios == null ? null : mutios.trim();
    }

    public String getTargetcity() {
        return targetcity;
    }

    public void setTargetcity(String targetcity) {
        this.targetcity = targetcity == null ? null : targetcity.trim();
    }

    public Integer getIos14params() {
        return ios14params;
    }

    public void setIos14params(Integer ios14params) {
        this.ios14params = ios14params;
    }

    public Integer getDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(Integer deleteflag) {
        this.deleteflag = deleteflag;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}