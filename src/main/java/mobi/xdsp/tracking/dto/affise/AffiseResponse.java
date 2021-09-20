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
 *
 * status =1 成功  0 失败
 */
public class AffiseResponse {

    private int status;
    private List<Offers> offers;
    private Pagination pagination;

    public AffiseResponse(int status, List<Offers> offers, Pagination pagination) {
        this.status = status;
        this.offers = offers;
        this.pagination = pagination;
    }

    public AffiseResponse() {
    }

    public void setStatus(int status) {
         this.status = status;
     }
     public int getStatus() {
         return status;
     }

    public void setOffers(List<Offers> offers) {
         this.offers = offers;
     }
     public List<Offers> getOffers() {
         return offers;
     }

    public void setPagination(Pagination pagination) {
         this.pagination = pagination;
     }
     public Pagination getPagination() {
         return pagination;
     }

}