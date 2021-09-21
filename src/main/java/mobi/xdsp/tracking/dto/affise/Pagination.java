/**
  * Copyright 2021 bejson.com 
  */
package mobi.xdsp.tracking.dto.affise;

/**
 * Auto-generated: 2021-09-21 13:47:23
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Pagination {

    private int per_page;
    private int total_count;
    private int page;
    public void setPer_page(int per_page) {
         this.per_page = per_page;
     }
     public int getPer_page() {
         return per_page;
     }

    public Pagination(int per_page, int total_count, int page) {
        this.per_page = per_page;
        this.total_count = total_count;
        this.page = page;
    }

    public Pagination() {
    }

    public void setTotal_count(int total_count) {
         this.total_count = total_count;
     }
     public int getTotal_count() {
         return total_count;
     }

    public void setPage(int page) {
         this.page = page;
     }
     public int getPage() {
         return page;
     }

}