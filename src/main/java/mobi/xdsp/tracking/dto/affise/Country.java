/**
  * Copyright 2021 bejson.com 
  */
package mobi.xdsp.tracking.dto.affise;
import java.util.List;

/**
 * Auto-generated: 2021-09-21 13:47:23
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Country {

    private List<String> allow;
    private List<String> deny;
    public void setAllow(List<String> allow) {
         this.allow = allow;
     }
     public List<String> getAllow() {
         return allow;
     }

    public void setDeny(List<String> deny) {
         this.deny = deny;
     }
     public List<String> getDeny() {
         return deny;
     }

}