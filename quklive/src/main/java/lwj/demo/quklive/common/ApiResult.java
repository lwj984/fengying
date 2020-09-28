package lwj.demo.quklive.common;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * @author liuweijia
 * @date 2017年10月13日 上午10:15:24
 * @since 1.0.0
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResult implements Serializable {

    private static final long serialVersionUID = -4697978296296631003L;

    /**
     * 错误码，0正常
     */
    private int code = 0;

    /**
     * 返回信息
     */
    private String message = "";

    /**
     * 返回数据
     */
    private Object data = "";
    
    /**
     * 服务器异常
     */
    private int serviceTime = 0;


    public ApiResult() {
        super();
    }

    public ApiResult(int code, String message) {
        super();
        this.code = code;
        this.message = message;
        this.serviceTime = Integer.parseInt(String.valueOf(System.currentTimeMillis()/1000));
    }

    public ApiResult(int code, String message, Object data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
        this.serviceTime = Integer.parseInt(String.valueOf(System.currentTimeMillis()/1000));
    }
    
    public ApiResult(ResponseCode code) {
		super();
		this.code = code.getCode();
		this.message = code.getMsg();
        this.serviceTime = Integer.parseInt(String.valueOf(System.currentTimeMillis()/1000));
	}

    /**
     * 获取成功状态结果. <br/>
     *
     * @param data
     * @return
     * @author yuliqian
     * @since JDK 1.8
     */
    public static ApiResult success(Object data) {
        ApiResult result = new ApiResult();
        result.setCode(ResponseCode.SUCCESS.getCode());
        result.setMessage(ResponseCode.SUCCESS.getMsg());
        result.setData(data);
        result.setServiceTime(Integer.parseInt(String.valueOf(System.currentTimeMillis()/1000)));
        return result;
    }

    /**
     * @see #success(Object)
     */
    public static ApiResult success() {
        return success(null);
    }

    public static ApiResult failure() {
        return failure(ResponseCode.FAIL.getCode(), ResponseCode.FAIL.getMsg(), null);
    }
    
    /**
     * 自定义错误信息. <br/>
     *
     * @param
     * @param message
     * @return
     * @author guoxing
     * @since JDK 1.8
     */
    public static ApiResult failure(String message) {
        return failure(ResponseCode.FAIL.getCode(), message, null);
    }


    /**
     * @param ex
     * @return
     * @author guoxing
     * @since JDK 1.8
     */
    public static ApiResult failure(CheckedException ex) {
        return failure(ex.getCode(), ex.getMessage(), null);
    }

    /**
     * @param data
     * @return
     * @author guoxing
     * @since JDK 1.8
     */
    public static ApiResult failure(Object data) {
        return failure(ResponseCode.FAIL.getCode(), ResponseCode.FAIL.getMsg(), data);
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
        result.setServiceTime(Integer.parseInt(String.valueOf(System.currentTimeMillis()/1000)));
        return result;
    }

    /**
     * 
     * 状态是否为成功. <br/>  
     *  
     * @author yuliqian  
     * @return  
     * @since JDK 1.8
     */
    public boolean isSuccess() {
        return code == 0;
    }
}
