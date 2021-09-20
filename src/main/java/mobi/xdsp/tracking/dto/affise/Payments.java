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
public class Payments {

    private List<String> countries;
    private List<String> cities;
    private List<String> devices;
    private List<String> os;
    private String goal;
    private int revenue;
    private String currency;
    private String title;
    private String type;
    private boolean country_exclude;
    public void setCountries(List<String> countries) {
         this.countries = countries;
     }
     public List<String> getCountries() {
         return countries;
     }

    public void setCities(List<String> cities) {
         this.cities = cities;
     }
     public List<String> getCities() {
         return cities;
     }

    public void setDevices(List<String> devices) {
         this.devices = devices;
     }
     public List<String> getDevices() {
         return devices;
     }

    public void setOs(List<String> os) {
         this.os = os;
     }
     public List<String> getOs() {
         return os;
     }

    public void setGoal(String goal) {
         this.goal = goal;
     }
     public String getGoal() {
         return goal;
     }

    public void setRevenue(int revenue) {
         this.revenue = revenue;
     }
     public int getRevenue() {
         return revenue;
     }

    public void setCurrency(String currency) {
         this.currency = currency;
     }
     public String getCurrency() {
         return currency;
     }

    public void setTitle(String title) {
         this.title = title;
     }
     public String getTitle() {
         return title;
     }

    public void setType(String type) {
         this.type = type;
     }
     public String getType() {
         return type;
     }

    public void setCountry_exclude(boolean country_exclude) {
         this.country_exclude = country_exclude;
     }
     public boolean getCountry_exclude() {
         return country_exclude;
     }

}