/**
 * Copyright 2022 bejson.com
 */
package mobi.xdsp.tracking.maf.dto;

import java.util.Date;

/**
 * Auto-generated: 2022-03-17 15:49:47
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class MafOffer {

    private Integer id;
    private String operation_type;
    private String type;
    private String copy_offer;
    private String channel;
    private String offer_id;
    private String attribute_provider;
    private String title;
    private String tracking_link;
    private String pkg_name;
    private String pid;
    private int payout;
    private int platform;
    private String country;
    private long max_clk_num;
    private String device;
    private int site_id;
    private int clk_id;
    private long site_clk_limit;
    private int site_install_limitation;
    private int conversion_flow;
    private int status;
    private String diy_siteid;
    private int start_hour;
    private int end_hour;
    private Date create_date;
    private Date update_date;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getChannel() {
        return channel;
    }

    public void setOffer_id(String offer_id) {
        this.offer_id = offer_id;
    }

    public String getOffer_id() {
        return offer_id;
    }

    public void setAttribute_provider(String attribute_provider) {
        this.attribute_provider = attribute_provider;
    }

    public String getAttribute_provider() {
        return attribute_provider;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTracking_link(String tracking_link) {
        this.tracking_link = tracking_link;
    }

    public String getTracking_link() {
        return tracking_link;
    }

    public void setPkg_name(String pkg_name) {
        this.pkg_name = pkg_name;
    }

    public String getPkg_name() {
        return pkg_name;
    }

    public void setPayout(int payout) {
        this.payout = payout;
    }

    public int getPayout() {
        return payout;
    }

    public void setPlatform(int platform) {
        this.platform = platform;
    }

    public int getPlatform() {
        return platform;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setMax_clk_num(long max_clk_num) {
        this.max_clk_num = max_clk_num;
    }

    public long getMax_clk_num() {
        return max_clk_num;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getDevice() {
        return device;
    }

    public void setSite_id(int site_id) {
        this.site_id = site_id;
    }

    public int getSite_id() {
        return site_id;
    }

    public void setClk_id(int clk_id) {
        this.clk_id = clk_id;
    }

    public int getClk_id() {
        return clk_id;
    }

    public void setSite_clk_limit(long site_clk_limit) {
        this.site_clk_limit = site_clk_limit;
    }

    public long getSite_clk_limit() {
        return site_clk_limit;
    }

    public void setSite_install_limitation(int site_install_limitation) {
        this.site_install_limitation = site_install_limitation;
    }

    public int getSite_install_limitation() {
        return site_install_limitation;
    }

    public void setConversion_flow(int conversion_flow) {
        this.conversion_flow = conversion_flow;
    }

    public int getConversion_flow() {
        return conversion_flow;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setDiy_siteid(String diy_siteid) {
        this.diy_siteid = diy_siteid;
    }

    public String getDiy_siteid() {
        return diy_siteid;
    }

    public void setStart_hour(int start_hour) {
        this.start_hour = start_hour;
    }

    public int getStart_hour() {
        return start_hour;
    }

    public void setEnd_hour(int end_hour) {
        this.end_hour = end_hour;
    }

    public int getEnd_hour() {
        return end_hour;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public String getOperation_type() {
        return operation_type;
    }

    public void setOperation_type(String operation_type) {
        this.operation_type = operation_type;
    }

    public String getCopy_offer() {
        return copy_offer;
    }

    public void setCopy_offer(String copy_offer) {
        this.copy_offer = copy_offer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}