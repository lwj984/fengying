package lwj.demo.dingding.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * @author liuweijia
 * @date 2017骞�10鏈�13鏃� 涓婂崍10:15:24
 * @since 1.0.0
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResult implements Serializable {

    private static final long serialVersionUID = -4697978296296631003L;

    /**
     * 閿欒鐮侊紝0姝ｅ父
     */
    private int code = 0;

    /**
     * 杩斿洖淇℃伅
     */
    private String message = "";

    /**
     * 杩斿洖鏁版嵁
     */
    private Object data = "";

    /**
     * 鏈嶅姟鍣ㄥ紓甯�
     */
    private int serviceTime = 0;

    public ApiResult() {
        super();
    }

    public ApiResult(int code, String message) {
        super();
        this.code = code;
        this.message = message;
        this.serviceTime = Integer.parseInt(String.valueOf(System.currentTimeMillis() / 1000));
    }

    public ApiResult(int code, String message, Object data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
        this.serviceTime = Integer.parseInt(String.valueOf(System.currentTimeMillis() / 1000));
    }

    /**
     * 鑾峰彇鎴愬姛鐘舵�佺粨鏋�. <br/>
     *
     * @param data
     * @return
     * @author yuliqian
     * @since JDK 1.8
     */
    public static ApiResult success(Object data) {
        ApiResult result = new ApiResult();
        result.setCode(0);
        result.setMessage("success");
        result.setData(data);
        result.setServiceTime(Integer.parseInt(String.valueOf(System.currentTimeMillis() / 1000)));
        return result;
    }

    /**
     * @see #success(Object)
     */
    public static ApiResult success() {
        return success(null);
    }

    /**
     * @param
     * @return
     * @throws
     * @author guoxing
     * @version
     * @created 2017/10/13 11:07
     * @since 2017/10/13 11:07
     **/
    public static ApiResult failure(int code, String msg, Object data) {
        ApiResult result = new ApiResult();
        result.setCode(code);
        result.setMessage(msg);
        result.setData(data);

        if (data instanceof String) {
            String m = (String) data;
            if (!m.matches("^.*error$")) {
                m += "error";
            }
        }
        result.setServiceTime(Integer.parseInt(String.valueOf(System.currentTimeMillis() / 1000)));
        return result;
    }

    public static ApiResult failure() {
        return failure(1, "error", null);
    }

    /**
     * 
     * 鐘舵�佹槸鍚︿负鎴愬姛. <br/>  
     *  
     * @author yuliqian  
     * @return  
     * @since JDK 1.8
     */
    public boolean isSuccess() {
        return code == 0;
    }
}
