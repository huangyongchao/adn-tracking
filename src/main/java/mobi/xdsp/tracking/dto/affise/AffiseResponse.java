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
public class AffiseResponse {

    private int status;
    private List<AffiseOffer> offers;
    private Pagination pagination;
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public AffiseResponse(int status, List<AffiseOffer> offers, Pagination pagination) {
        this.status = status;
        this.offers = offers;
        this.pagination = pagination;
    }

    public AffiseResponse(int status, String error) {
        this.status = status;
        this.error = error;
    }

    public AffiseResponse() {
    }

    public void setStatus(int status) {
         this.status = status;
     }
     public int getStatus() {
         return status;
     }

    public void setOffers(List<AffiseOffer> offers) {
         this.offers = offers;
     }
     public List<AffiseOffer> getOffers() {
         return offers;
     }

    public void setPagination(Pagination pagination) {
         this.pagination = pagination;
     }
     public Pagination getPagination() {
         return pagination;
     }

}