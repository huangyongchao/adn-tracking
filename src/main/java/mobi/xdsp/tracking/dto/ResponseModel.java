package mobi.xdsp.tracking.dto;

import org.apache.http.HttpStatus;

import java.io.Serializable;
import java.util.List;

public class ResponseModel<T> implements Serializable {
    /**
     * 执行结果编码 严格参照HTTP STATUS
     */
    private int code = HttpStatus.SC_OK;
    private String msg;
    private List<T> data;
    private T obj;

    /**
     * 返回数据集合的模板
     *
     * @param code
     * @param msg
     * @param data
     */
    public ResponseModel(int code, String msg, List<T> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 返回单条数据的模板
     *
     * @param code
     * @param msg
     * @param obj
     */
    public ResponseModel(int code, String msg, T obj) {
        this.code = code;
        this.msg = msg;
        this.obj = obj;
    }

    /**
     * 返回执行状态的模板
     *
     * @param code
     * @param msg
     */
    public ResponseModel(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
