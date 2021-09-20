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
public class Targeting {

    private Country country;
    private Region region;
    private City city;
    private Os os;
    private Isp isp;
    private Ip ip;
    private Browser browser;
    private Brand brand;
    private List<String> device_type;
    private List<String> connection;
    private String id;
    private List<String> sub_regexps;
    public void setCountry(Country country) {
         this.country = country;
     }
     public Country getCountry() {
         return country;
     }

    public void setRegion(Region region) {
         this.region = region;
     }
     public Region getRegion() {
         return region;
     }

    public void setCity(City city) {
         this.city = city;
     }
     public City getCity() {
         return city;
     }

    public void setOs(Os os) {
         this.os = os;
     }
     public Os getOs() {
         return os;
     }

    public void setIsp(Isp isp) {
         this.isp = isp;
     }
     public Isp getIsp() {
         return isp;
     }

    public void setIp(Ip ip) {
         this.ip = ip;
     }
     public Ip getIp() {
         return ip;
     }

    public void setBrowser(Browser browser) {
         this.browser = browser;
     }
     public Browser getBrowser() {
         return browser;
     }

    public void setBrand(Brand brand) {
         this.brand = brand;
     }
     public Brand getBrand() {
         return brand;
     }

    public void setDevice_type(List<String> device_type) {
         this.device_type = device_type;
     }
     public List<String> getDevice_type() {
         return device_type;
     }

    public void setConnection(List<String> connection) {
         this.connection = connection;
     }
     public List<String> getConnection() {
         return connection;
     }

    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setSub_regexps(List<String> sub_regexps) {
         this.sub_regexps = sub_regexps;
     }
     public List<String> getSub_regexps() {
         return sub_regexps;
     }

}