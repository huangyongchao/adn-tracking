/**
  * Copyright 2021 bejson.com 
  */
package mobi.xdsp.tracking.dto.affise;
import java.util.List;

/**
 * Auto-generated: 2021-09-20 22:52:27
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Offers {

    private int id;
    private String offer_id;
    private String title;
    private String preview_url;
    private Description_lang description_lang;
    private double cr;
    private int epc;
    private String logo;
    private String logo_source;
    private String stop_at;
    private List<Sources> sources;
    private List<String> categories;
    private List<Full_categories> full_categories;
    private List<Payments> payments;
    private List<String> caps;
    private boolean required_approval;
    private int strictly_country;
    private List<String> strictly_os;
    private List<String> strictly_brands;
    private boolean is_cpi;
    private List<String> creatives;
    private String creatives_zip;
    private String impressions_link;
    private List<String> landings;
    private List<Links> links;
    private String macro_url;
    private String link;
    private boolean use_https;
    private boolean use_http;
    private int hold_period;
    private Kpi kpi;
    private String click_session;
    private String minimal_click_session;
    private List<String> strictly_isp;
    private List<String> restriction_isp;
    private List<Targeting> targeting;
    private boolean consider_personal_targeting_only;
    private boolean hosts_only;
    private boolean uniq_ip_only;
    private int reject_not_uniq_ip;
    private boolean sign_clicks_appsflyer_key;
    public void setId(int id) {
         this.id = id;
     }
     public int getId() {
         return id;
     }

    public void setOffer_id(String offer_id) {
         this.offer_id = offer_id;
     }
     public String getOffer_id() {
         return offer_id;
     }

    public void setTitle(String title) {
         this.title = title;
     }
     public String getTitle() {
         return title;
     }

    public void setPreview_url(String preview_url) {
         this.preview_url = preview_url;
     }
     public String getPreview_url() {
         return preview_url;
     }

    public void setDescription_lang(Description_lang description_lang) {
         this.description_lang = description_lang;
     }
     public Description_lang getDescription_lang() {
         return description_lang;
     }

    public void setCr(double cr) {
         this.cr = cr;
     }
     public double getCr() {
         return cr;
     }

    public void setEpc(int epc) {
         this.epc = epc;
     }
     public int getEpc() {
         return epc;
     }

    public void setLogo(String logo) {
         this.logo = logo;
     }
     public String getLogo() {
         return logo;
     }

    public void setLogo_source(String logo_source) {
         this.logo_source = logo_source;
     }
     public String getLogo_source() {
         return logo_source;
     }

    public void setStop_at(String stop_at) {
         this.stop_at = stop_at;
     }
     public String getStop_at() {
         return stop_at;
     }

    public void setSources(List<Sources> sources) {
         this.sources = sources;
     }
     public List<Sources> getSources() {
         return sources;
     }

    public void setCategories(List<String> categories) {
         this.categories = categories;
     }
     public List<String> getCategories() {
         return categories;
     }

    public void setFull_categories(List<Full_categories> full_categories) {
         this.full_categories = full_categories;
     }
     public List<Full_categories> getFull_categories() {
         return full_categories;
     }

    public void setPayments(List<Payments> payments) {
         this.payments = payments;
     }
     public List<Payments> getPayments() {
         return payments;
     }

    public void setCaps(List<String> caps) {
         this.caps = caps;
     }
     public List<String> getCaps() {
         return caps;
     }

    public void setRequired_approval(boolean required_approval) {
         this.required_approval = required_approval;
     }
     public boolean getRequired_approval() {
         return required_approval;
     }

    public void setStrictly_country(int strictly_country) {
         this.strictly_country = strictly_country;
     }
     public int getStrictly_country() {
         return strictly_country;
     }

    public void setStrictly_os(List<String> strictly_os) {
         this.strictly_os = strictly_os;
     }
     public List<String> getStrictly_os() {
         return strictly_os;
     }

    public void setStrictly_brands(List<String> strictly_brands) {
         this.strictly_brands = strictly_brands;
     }
     public List<String> getStrictly_brands() {
         return strictly_brands;
     }

    public void setIs_cpi(boolean is_cpi) {
         this.is_cpi = is_cpi;
     }
     public boolean getIs_cpi() {
         return is_cpi;
     }

    public void setCreatives(List<String> creatives) {
         this.creatives = creatives;
     }
     public List<String> getCreatives() {
         return creatives;
     }

    public void setCreatives_zip(String creatives_zip) {
         this.creatives_zip = creatives_zip;
     }
     public String getCreatives_zip() {
         return creatives_zip;
     }

    public void setImpressions_link(String impressions_link) {
         this.impressions_link = impressions_link;
     }
     public String getImpressions_link() {
         return impressions_link;
     }

    public void setLandings(List<String> landings) {
         this.landings = landings;
     }
     public List<String> getLandings() {
         return landings;
     }

    public void setLinks(List<Links> links) {
         this.links = links;
     }
     public List<Links> getLinks() {
         return links;
     }

    public void setMacro_url(String macro_url) {
         this.macro_url = macro_url;
     }
     public String getMacro_url() {
         return macro_url;
     }

    public void setLink(String link) {
         this.link = link;
     }
     public String getLink() {
         return link;
     }

    public void setUse_https(boolean use_https) {
         this.use_https = use_https;
     }
     public boolean getUse_https() {
         return use_https;
     }

    public void setUse_http(boolean use_http) {
         this.use_http = use_http;
     }
     public boolean getUse_http() {
         return use_http;
     }

    public void setHold_period(int hold_period) {
         this.hold_period = hold_period;
     }
     public int getHold_period() {
         return hold_period;
     }

    public void setKpi(Kpi kpi) {
         this.kpi = kpi;
     }
     public Kpi getKpi() {
         return kpi;
     }

    public void setClick_session(String click_session) {
         this.click_session = click_session;
     }
     public String getClick_session() {
         return click_session;
     }

    public void setMinimal_click_session(String minimal_click_session) {
         this.minimal_click_session = minimal_click_session;
     }
     public String getMinimal_click_session() {
         return minimal_click_session;
     }

    public void setStrictly_isp(List<String> strictly_isp) {
         this.strictly_isp = strictly_isp;
     }
     public List<String> getStrictly_isp() {
         return strictly_isp;
     }

    public void setRestriction_isp(List<String> restriction_isp) {
         this.restriction_isp = restriction_isp;
     }
     public List<String> getRestriction_isp() {
         return restriction_isp;
     }

    public void setTargeting(List<Targeting> targeting) {
         this.targeting = targeting;
     }
     public List<Targeting> getTargeting() {
         return targeting;
     }

    public void setConsider_personal_targeting_only(boolean consider_personal_targeting_only) {
         this.consider_personal_targeting_only = consider_personal_targeting_only;
     }
     public boolean getConsider_personal_targeting_only() {
         return consider_personal_targeting_only;
     }

    public void setHosts_only(boolean hosts_only) {
         this.hosts_only = hosts_only;
     }
     public boolean getHosts_only() {
         return hosts_only;
     }

    public void setUniq_ip_only(boolean uniq_ip_only) {
         this.uniq_ip_only = uniq_ip_only;
     }
     public boolean getUniq_ip_only() {
         return uniq_ip_only;
     }

    public void setReject_not_uniq_ip(int reject_not_uniq_ip) {
         this.reject_not_uniq_ip = reject_not_uniq_ip;
     }
     public int getReject_not_uniq_ip() {
         return reject_not_uniq_ip;
     }

    public void setSign_clicks_appsflyer_key(boolean sign_clicks_appsflyer_key) {
         this.sign_clicks_appsflyer_key = sign_clicks_appsflyer_key;
     }
     public boolean getSign_clicks_appsflyer_key() {
         return sign_clicks_appsflyer_key;
     }

}