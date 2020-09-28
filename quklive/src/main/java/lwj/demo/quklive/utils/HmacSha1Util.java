package lwj.demo.quklive.utils;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HmacSha1Util {

    public static byte[] hamcsha1(byte[] data, byte[] key) {
        try {
            SecretKeySpec signingKey = new SecretKeySpec(key, "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);
            return mac.doFinal(data);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        // String appKey = "6ztxklilkjxuuy3m";
        // String appSecret = "HjrAO3vZEZSfAu5x";
        // long time = 1486528134626L;
        String appKey = "y5vxpw9gdkegeenk";
        String appSecret = "71SYb04Cgx0Ap6FS";
        long time = System.currentTimeMillis();
        System.out.println(time);
        String content = "appKey=" + appKey + "&nonce=" + time;
        System.out.println(Base64Util.encode(hamcsha1(content.getBytes(), appSecret.getBytes())));
    }
}
