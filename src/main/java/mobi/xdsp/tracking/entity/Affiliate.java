package mobi.xdsp.tracking.entity;

import java.util.Date;

public class Affiliate {
    private Integer id;

    private String affiliatename;

    private String publisherid;

    private String username;

    private String password;

    private String loginurl;

    private String token;

    private String parastrack;

    private String apiurl;

    private String country;

    private String status;

    private Byte checklevel;

    private Byte runlevel;

    private Integer campaignmax;

    private Integer clickmax;

    private Byte jumpmin;

    private Byte jumpmax;

    private Date registerdate;

    private String createuser;

    private Date updatetime;

    private String updateuser;

    private String manageruser;

    private String opuser;

    private String bduser;

    private Integer platformlevel;

    private String company;

    private Integer generatesubid;

    private Integer autoopen;

    private Integer autoadjust;

    private String postback;

    private Integer directguest;

    private String payevent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAffiliatename() {
        return affiliatename;
    }

    public void setAffiliatename(String affiliatename) {
        this.affiliatename = affiliatename == null ? null : affiliatename.trim();
    }

    public String getPublisherid() {
        return publisherid;
    }

    public void setPublisherid(String publisherid) {
        this.publisherid = publisherid == null ? null : publisherid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getLoginurl() {
        return loginurl;
    }

    public void setLoginurl(String loginurl) {
        this.loginurl = loginurl == null ? null : loginurl.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public String getParastrack() {
        return parastrack;
    }

    public void setParastrack(String parastrack) {
        this.parastrack = parastrack == null ? null : parastrack.trim();
    }

    public String getApiurl() {
        return apiurl;
    }

    public void setApiurl(String apiurl) {
        this.apiurl = apiurl == null ? null : apiurl.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Byte getChecklevel() {
        return checklevel;
    }

    public void setChecklevel(Byte checklevel) {
        this.checklevel = checklevel;
    }

    public Byte getRunlevel() {
        return runlevel;
    }

    public void setRunlevel(Byte runlevel) {
        this.runlevel = runlevel;
    }

    public Integer getCampaignmax() {
        return campaignmax;
    }

    public void setCampaignmax(Integer campaignmax) {
        this.campaignmax = campaignmax;
    }

    public Integer getClickmax() {
        return clickmax;
    }

    public void setClickmax(Integer clickmax) {
        this.clickmax = clickmax;
    }

    public Byte getJumpmin() {
        return jumpmin;
    }

    public void setJumpmin(Byte jumpmin) {
        this.jumpmin = jumpmin;
    }

    public Byte getJumpmax() {
        return jumpmax;
    }

    public void setJumpmax(Byte jumpmax) {
        this.jumpmax = jumpmax;
    }

    public Date getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(Date registerdate) {
        this.registerdate = registerdate;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser == null ? null : createuser.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser == null ? null : updateuser.trim();
    }

    public String getManageruser() {
        return manageruser;
    }

    public void setManageruser(String manageruser) {
        this.manageruser = manageruser == null ? null : manageruser.trim();
    }

    public String getOpuser() {
        return opuser;
    }

    public void setOpuser(String opuser) {
        this.opuser = opuser == null ? null : opuser.trim();
    }

    public String getBduser() {
        return bduser;
    }

    public void setBduser(String bduser) {
        this.bduser = bduser == null ? null : bduser.trim();
    }

    public Integer getPlatformlevel() {
        return platformlevel;
    }

    public void setPlatformlevel(Integer platformlevel) {
        this.platformlevel = platformlevel;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public Integer getGeneratesubid() {
        return generatesubid;
    }

    public void setGeneratesubid(Integer generatesubid) {
        this.generatesubid = generatesubid;
    }

    public Integer getAutoopen() {
        return autoopen;
    }

    public void setAutoopen(Integer autoopen) {
        this.autoopen = autoopen;
    }

    public Integer getAutoadjust() {
        return autoadjust;
    }

    public void setAutoadjust(Integer autoadjust) {
        this.autoadjust = autoadjust;
    }

    public String getPostback() {
        return postback;
    }

    public void setPostback(String postback) {
        this.postback = postback == null ? null : postback.trim();
    }

    public Integer getDirectguest() {
        return directguest;
    }

    public void setDirectguest(Integer directguest) {
        this.directguest = directguest;
    }

    public String getPayevent() {
        return payevent;
    }

    public void setPayevent(String payevent) {
        this.payevent = payevent == null ? null : payevent.trim();
    }
}