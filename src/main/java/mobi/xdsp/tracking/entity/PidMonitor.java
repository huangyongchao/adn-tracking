package mobi.xdsp.tracking.entity;

import java.util.Date;

public class PidMonitor {
    private Integer id;

    private String pid;

    private Integer blocking;

    private Date blockst;

    private Date blocket;

    private String account;

    private String pwd;

    private String cookie;

    private String cookie1;

    private String am;

    private String amemail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public Integer getBlocking() {
        return blocking;
    }

    public void setBlocking(Integer blocking) {
        this.blocking = blocking;
    }

    public Date getBlockst() {
        return blockst;
    }

    public void setBlockst(Date blockst) {
        this.blockst = blockst;
    }

    public Date getBlocket() {
        return blocket;
    }

    public void setBlocket(Date blocket) {
        this.blocket = blocket;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie == null ? null : cookie.trim();
    }

    public String getCookie1() {
        return cookie1;
    }

    public void setCookie1(String cookie1) {
        this.cookie1 = cookie1 == null ? null : cookie1.trim();
    }

    public String getAm() {
        return am;
    }

    public void setAm(String am) {
        this.am = am == null ? null : am.trim();
    }

    public String getAmemail() {
        return amemail;
    }

    public void setAmemail(String amemail) {
        this.amemail = amemail == null ? null : amemail.trim();
    }
}