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
public class Links {

    private String id;
    private String title;
    private String hash;
    private String url;
    private List<String> postbacks;
    private String created;
    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setTitle(String title) {
         this.title = title;
     }
     public String getTitle() {
         return title;
     }

    public void setHash(String hash) {
         this.hash = hash;
     }
     public String getHash() {
         return hash;
     }

    public void setUrl(String url) {
         this.url = url;
     }
     public String getUrl() {
         return url;
     }

    public void setPostbacks(List<String> postbacks) {
         this.postbacks = postbacks;
     }
     public List<String> getPostbacks() {
         return postbacks;
     }

    public void setCreated(String created) {
         this.created = created;
     }
     public String getCreated() {
         return created;
     }

}