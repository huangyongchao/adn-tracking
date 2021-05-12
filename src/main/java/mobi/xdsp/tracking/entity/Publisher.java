package mobi.xdsp.tracking.entity;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
@Data
@ToString
public class Publisher {
    private Integer id;

    private String password;

    private String email;

    private String companyname;

    private String token;

    private String country;

    private String province;

    private String city;

    private String address;

    private String address2;

    private String workphone;

    private String billinginfo;

    private Integer applytype;

    private BigDecimal dailybudget;

    private BigDecimal monthbudget;

    private Integer dailycap;

    private Integer monthcap;

    private Integer clickcap;

    private Integer payoutrate;

    private Integer redirect;

    private String postbackurl;

    private String postbackeventurl;

    private Integer postbackstatus;

    private Integer status;

    private Date createtime;

    private Date updatetime;

    private String lastname;

    private String createuser;

    private String updateuser;

    private String manageruser;

    private Integer refadvid;

    private Integer innercompany;

    private Integer subemal;

    private String opmanager;

    private String bdmanager;

    private Integer autorun;

    private Integer autoadjust;

    private Integer autoclose;

    private String platformlevel;

    private String strategy1;

    private String strategy2;

    private String strategy3;

    private String autoparam1;

    private String autoparam2;

    private String autoparam3;

    private String instructions;

    private String contactperson;

    private String financeperson;

    private String contactemal;

    private String financeemail;

    private String invoicetpl;

    private Integer mixrate;

    private Integer redirectrate;

    private Integer deductrate;

    private Integer sysuserid;

    private Integer utc;

    private Integer deleteflag;

    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname == null ? null : companyname.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2 == null ? null : address2.trim();
    }

    public String getWorkphone() {
        return workphone;
    }

    public void setWorkphone(String workphone) {
        this.workphone = workphone == null ? null : workphone.trim();
    }

    public String getBillinginfo() {
        return billinginfo;
    }

    public void setBillinginfo(String billinginfo) {
        this.billinginfo = billinginfo == null ? null : billinginfo.trim();
    }

    public Integer getApplytype() {
        return applytype;
    }

    public void setApplytype(Integer applytype) {
        this.applytype = applytype;
    }

    public BigDecimal getDailybudget() {
        return dailybudget;
    }

    public void setDailybudget(BigDecimal dailybudget) {
        this.dailybudget = dailybudget;
    }

    public BigDecimal getMonthbudget() {
        return monthbudget;
    }

    public void setMonthbudget(BigDecimal monthbudget) {
        this.monthbudget = monthbudget;
    }

    public Integer getDailycap() {
        return dailycap;
    }

    public void setDailycap(Integer dailycap) {
        this.dailycap = dailycap;
    }

    public Integer getMonthcap() {
        return monthcap;
    }

    public void setMonthcap(Integer monthcap) {
        this.monthcap = monthcap;
    }

    public Integer getClickcap() {
        return clickcap;
    }

    public void setClickcap(Integer clickcap) {
        this.clickcap = clickcap;
    }

    public Integer getPayoutrate() {
        return payoutrate;
    }

    public void setPayoutrate(Integer payoutrate) {
        this.payoutrate = payoutrate;
    }

    public Integer getRedirect() {
        return redirect;
    }

    public void setRedirect(Integer redirect) {
        this.redirect = redirect;
    }

    public String getPostbackurl() {
        return postbackurl;
    }

    public void setPostbackurl(String postbackurl) {
        this.postbackurl = postbackurl == null ? null : postbackurl.trim();
    }

    public String getPostbackeventurl() {
        return postbackeventurl;
    }

    public void setPostbackeventurl(String postbackeventurl) {
        this.postbackeventurl = postbackeventurl == null ? null : postbackeventurl.trim();
    }

    public Integer getPostbackstatus() {
        return postbackstatus;
    }

    public void setPostbackstatus(Integer postbackstatus) {
        this.postbackstatus = postbackstatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname == null ? null : lastname.trim();
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser == null ? null : createuser.trim();
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

    public Integer getRefadvid() {
        return refadvid;
    }

    public void setRefadvid(Integer refadvid) {
        this.refadvid = refadvid;
    }

    public Integer getInnercompany() {
        return innercompany;
    }

    public void setInnercompany(Integer innercompany) {
        this.innercompany = innercompany;
    }

    public Integer getSubemal() {
        return subemal;
    }

    public void setSubemal(Integer subemal) {
        this.subemal = subemal;
    }

    public String getOpmanager() {
        return opmanager;
    }

    public void setOpmanager(String opmanager) {
        this.opmanager = opmanager == null ? null : opmanager.trim();
    }

    public String getBdmanager() {
        return bdmanager;
    }

    public void setBdmanager(String bdmanager) {
        this.bdmanager = bdmanager == null ? null : bdmanager.trim();
    }

    public Integer getAutorun() {
        return autorun;
    }

    public void setAutorun(Integer autorun) {
        this.autorun = autorun;
    }

    public Integer getAutoadjust() {
        return autoadjust;
    }

    public void setAutoadjust(Integer autoadjust) {
        this.autoadjust = autoadjust;
    }

    public Integer getAutoclose() {
        return autoclose;
    }

    public void setAutoclose(Integer autoclose) {
        this.autoclose = autoclose;
    }

    public String getPlatformlevel() {
        return platformlevel;
    }

    public void setPlatformlevel(String platformlevel) {
        this.platformlevel = platformlevel == null ? null : platformlevel.trim();
    }

    public String getStrategy1() {
        return strategy1;
    }

    public void setStrategy1(String strategy1) {
        this.strategy1 = strategy1 == null ? null : strategy1.trim();
    }

    public String getStrategy2() {
        return strategy2;
    }

    public void setStrategy2(String strategy2) {
        this.strategy2 = strategy2 == null ? null : strategy2.trim();
    }

    public String getStrategy3() {
        return strategy3;
    }

    public void setStrategy3(String strategy3) {
        this.strategy3 = strategy3 == null ? null : strategy3.trim();
    }

    public String getAutoparam1() {
        return autoparam1;
    }

    public void setAutoparam1(String autoparam1) {
        this.autoparam1 = autoparam1 == null ? null : autoparam1.trim();
    }

    public String getAutoparam2() {
        return autoparam2;
    }

    public void setAutoparam2(String autoparam2) {
        this.autoparam2 = autoparam2 == null ? null : autoparam2.trim();
    }

    public String getAutoparam3() {
        return autoparam3;
    }

    public void setAutoparam3(String autoparam3) {
        this.autoparam3 = autoparam3 == null ? null : autoparam3.trim();
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions == null ? null : instructions.trim();
    }

    public String getContactperson() {
        return contactperson;
    }

    public void setContactperson(String contactperson) {
        this.contactperson = contactperson == null ? null : contactperson.trim();
    }

    public String getFinanceperson() {
        return financeperson;
    }

    public void setFinanceperson(String financeperson) {
        this.financeperson = financeperson == null ? null : financeperson.trim();
    }

    public String getContactemal() {
        return contactemal;
    }

    public void setContactemal(String contactemal) {
        this.contactemal = contactemal == null ? null : contactemal.trim();
    }

    public String getFinanceemail() {
        return financeemail;
    }

    public void setFinanceemail(String financeemail) {
        this.financeemail = financeemail == null ? null : financeemail.trim();
    }

    public String getInvoicetpl() {
        return invoicetpl;
    }

    public void setInvoicetpl(String invoicetpl) {
        this.invoicetpl = invoicetpl == null ? null : invoicetpl.trim();
    }

    public Integer getMixrate() {
        return mixrate;
    }

    public void setMixrate(Integer mixrate) {
        this.mixrate = mixrate;
    }

    public Integer getRedirectrate() {
        return redirectrate;
    }

    public void setRedirectrate(Integer redirectrate) {
        this.redirectrate = redirectrate;
    }

    public Integer getDeductrate() {
        return deductrate;
    }

    public void setDeductrate(Integer deductrate) {
        this.deductrate = deductrate;
    }

    public Integer getSysuserid() {
        return sysuserid;
    }

    public void setSysuserid(Integer sysuserid) {
        this.sysuserid = sysuserid;
    }

    public Integer getUtc() {
        return utc;
    }

    public void setUtc(Integer utc) {
        this.utc = utc;
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