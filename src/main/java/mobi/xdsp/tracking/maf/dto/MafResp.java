/**
  * Copyright 2022 bejson.com 
  */
package mobi.xdsp.tracking.maf.dto;

/**
 * Auto-generated: 2022-03-17 15:45:29
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class MafResp {

    private int code;
    private Data data;
    private String message;
    public void setCode(int code) {
         this.code = code;
     }
     public int getCode() {
         return code;
     }

    public void setData(Data data) {
         this.data = data;
     }
     public Data getData() {
         return data;
     }

    public void setMessage(String message) {
         this.message = message;
     }
     public String getMessage() {
         return message;
     }

}