package lwj.demo.quklive.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * base64编码
 *
 * @author liuwei 2016-12-21 12:21
 * @since 1.0.0
 */
public class Base64Util {

    // 默认编码
    public static String DEFAULT_CHARSET = "utf-8";
    public static String UTF8_CHARSET    = "utf-8";
    public static String GBK_CHARSET     = "gbk";
    public static String ISO_CHARSET     = "iso8859-1";

    /**
     * 编码函数
     * 
     * @param decodeStr
     * @param 编码方式utf-8/gbk/iso8859-1..
     * @return
     */
    public static String encode(String decodeStr, String charset) {
        try {
            return encode(decodeStr.getBytes(charset), charset, false);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String encodeSafe(String decodeStr, String charset) {
        try {
            return encode(decodeStr.getBytes(charset), charset, true);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 编码函数
     * 
     * @param decodeStr
     * @return
     */
    public static String encode(String decodeStr) {
        return encode(decodeStr, DEFAULT_CHARSET);
    }

    /**
     * 编码函数
     * 
     * @param decodeStr
     * @return
     */
    public static String encodeSafe(String decodeStr) {
        return encodeSafe(decodeStr, DEFAULT_CHARSET);
    }

    /**
     * 编码函数 utf-8
     * 
     * @param data
     * @return
     */
    public static String encode(byte[] data) {
        return encode(data, DEFAULT_CHARSET, false);
    }
    
    /**
     * 编码函数 utf-8
     * 
     * @param data
     * @return
     */
    public static String encodeSafe(byte[] data) {
        return encode(data, DEFAULT_CHARSET, true);
    }

    /**
     * 编码函数 utf-8
     * 
     * @param data
     * @return
     */
    public static String encode(byte[] data, String charset, boolean urlSafe) {
        // 去掉最后的换行
        String s = null;
        String temp = "";
        try {
            s = new String(new org.apache.commons.codec.binary.Base64(urlSafe).encode(data),
                charset)
                    .trim();
            BufferedReader br = new BufferedReader(new java.io.StringReader(s));
            String line = br.readLine();
            while (line != null) {
                temp += line;
                line = br.readLine();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp;
    }

    /**
     * 编码函数UTF-8
     * 
     * @param decodeStr
     * @return
     */
    public static String encodeUTF8(String decodeStr, boolean urlSafe) {
        // 去掉最后的换行
        String s = null;
        String temp = "";
        try {
            s = new String(new org.apache.commons.codec.binary.Base64(urlSafe)
                .encode(decodeStr.getBytes(UTF8_CHARSET)), UTF8_CHARSET).trim();
            BufferedReader br = new BufferedReader(new java.io.StringReader(s));
            String line = br.readLine();
            while (line != null) {
                temp += line;
                line = br.readLine();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp;
    }

    /**
     * 解码函数
     * 
     * @param encodeStr
     * @return
     */
    public static String decode(String encodeStr) {
        return decode(encodeStr, DEFAULT_CHARSET);
    }

    /**
     * 解码函数(url安全)
     * 
     * @param encodeStr
     * @return
     */
    public static String decodeSafe(String encodeStr) {
        return decode(encodeStr, DEFAULT_CHARSET);
    }

    /**
     * 解码函数
     * 
     * @param encodeStr
     * @return
     */
    public static String decode(String encodeStr, String charset) {
        try {
            return new String(decodeToByte(encodeStr, charset, false), charset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 解码函数(url安全)
     * 
     * @param encodeStr
     * @return
     */
    public static String decodeSafe(String encodeStr, String charset) {
        try {
            return new String(decodeToByte(encodeStr, charset, true), charset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 解码函数
     * 
     * @param encodeStr
     * @return
     */
    public static byte[] decodeToByte(String encodeStr, String charset, boolean urlSafe) {
        try {
            return new org.apache.commons.codec.binary.Base64(urlSafe)
                .decode(encodeStr.getBytes(charset));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解码函数
     * 
     * @param encodeStr
     * @return
     */
    public static byte[] decodeToByte(String encodeStr) {
        return decodeToByte(encodeStr, DEFAULT_CHARSET, false);
    }

    /**
     * 解码函数
     * 
     * @param data
     * @return
     */
    public static String decode(byte[] data) {
        return decode(data, DEFAULT_CHARSET, false);
    }

    /**
     * 解码函数
     * 
     * @param data
     * @return
     */
    public static String decode(byte[] data, String charset, boolean urlSafe) {
        try {
            return new String(new org.apache.commons.codec.binary.Base64(urlSafe).decode(data),
                charset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args){
        String userToken = "NgDXJv3Ua96u9cl7qXvGfn4Rl3evwWLeqenaOPAlkWl3E5d+rcBi1az1zmC7IYRpdwCTdqvYYNGk68B0t3rWNmtDwC6pw2aE\\/vzLfvoswX99RJV+oMNm1K7zmXqsf8F4KQ==";
        userToken = userToken.replaceAll(" ", "+");
        System.out.println(Base64Util.decode(userToken, Base64Util.ISO_CHARSET));

        try {
            userToken = userToken.replaceAll(" ", "+");
            String token = Base64Util.decode(userToken, Base64Util.ISO_CHARSET);
            System.out.println(mask(token));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static final String mask = "c9c959b24b9da7d9b2f8146b4d6931a1";

    private static String mask(String data) {
        byte[] md5Data = MD5.getMD5(mask);
        int len = data.length();
        char[] dc = data.toCharArray();

        String result = "";
        int i = 0;
        while (i < len) {
            int j = 0;
            while (i < len && j < 16) {
                result += (char) (dc[i] ^ (md5Data[j] & 0xff));
                i++;
                j++;
            }
        }

        return result;
    }
}
