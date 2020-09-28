package lwj.demo.quklive.utils;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Random;

import lombok.extern.slf4j.Slf4j;
import lwj.demo.quklive.common.CheckedException;
import lwj.demo.quklive.common.ResponseCode;

/**
 * MD5 <br/>
 * 
 * @author yuliqian
 * @data 2017年1月11日下午4:37:14
 * @since 1.0.0
 */
@Slf4j
public class MD5 {
	
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
			   "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    /**
     * 
     * md5加密. <br/>
     * 
     * @author yuliqian
     * @param str
     * @return 返回md5报文摘要16字节长度的原始二进制格式
     * @throws CheckedException
     * @since JDK 1.8
     */
    public static byte[] getMD5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
            byte[] bytes = messageDigest.digest();
            return bytes;
        } catch (Exception e) {
            log.error("MD5 加密出现异常!" + e.getMessage());
        }
        return null;
    }

    /**
     * 
     * md5加密. <br/>
     * 
     * @author yuliqian
     * @param str
     * @return 32 字符十六进制数字形式返回散列值
     * @throws CheckedException
     * @since JDK 1.8
     */
    public static String getMD5String(String str) throws CheckedException {
        StringBuffer buffer = new StringBuffer();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
            byte[] bytes = messageDigest.digest();
            for (byte b : bytes) {
                if (Integer.toHexString(0xFF & b).length() == 1) {
                    buffer.append("0");
                    buffer.append(Integer.toHexString(0xFF & b));
                } else {
                    buffer.append(Integer.toHexString(0xFF & b));
                }
            }
        } catch (Exception e) {
            throw new CheckedException(ResponseCode.FAIL.getCode(),"MD5 加密出现异常!");
        }
        return buffer.toString();
    }

    public static String pwdEncrypt(String pwd, String regIp) throws CheckedException {
        String ipMd5 = getMD5String(regIp).substring(0, 16);
        String pwdMd5 = getMD5String(pwd);
        return getMD5String(pwdMd5 + ipMd5);
    }
    
    /**
     * 生成随机盐
     * @return
     * @author fanlifeng
     * @date 2018-02-05 10:11
     * @since 2.0.0
     */
    public static String createSalt() {
    	char[] chars="0123456789abcdef".toCharArray();
    	char[] saltchars=new char[6];
    	Random RANDOM = new SecureRandom();
    	for(int i=0;i<6;i++)
    	{
    	int n=RANDOM.nextInt(16);
    	saltchars[i]=chars[n];
    	}
    	String salt=new String(saltchars);
    	return salt;
    }
    
    public static void main(String[] args) {
    	for(int i=0;i<10;i++){
    		System.out.println(createSalt());
    	}
    	
	}
}
