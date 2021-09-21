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
public class Items {

    private List<String> iOS;
    private List<String> android;
    public void setIOS(List<String> iOS) {
         this.iOS = iOS;
     }
     public List<String> getIOS() {
         return iOS;
     }

    public List<String> getAndroid() {
        return android;
    }

    public void setAndroid(List<String> android) {
        this.android = android;
    }
}