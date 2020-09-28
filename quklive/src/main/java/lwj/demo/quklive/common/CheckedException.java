package lwj.demo.quklive.common;

/**
 * 通用自定义异常类 <br/>
 * 
 * @author yuliqian
 * @data 2016年12月2日下午3:09:13
 * @since 1.0.0
 */
public class CheckedException extends Exception {

    private static final long serialVersionUID = 4786214884790768036L;

    private int               code             = ResponseCode.FAIL.getCode();

    private String            message;

    public CheckedException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public CheckedException(ResponseCode httpCode) {
        this.code = httpCode.getCode();
        this.message = httpCode.getMsg();
    }

    public CheckedException(String message) {
    	this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
