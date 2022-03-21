/**
 * Copyright 2022 bejson.com
 */
package mobi.xdsp.tracking.maf.dto;

import java.util.List;

/**
 * Auto-generated: 2022-03-17 15:45:29
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Data {

    private List<MafOffer> data;
    private Page page;

    public void setData(List<MafOffer> data) {
        this.data = data;
    }

    public List<MafOffer> getData() {
        return data;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Page getPage() {
        return page;
    }

}