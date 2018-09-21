package com.minol.utils;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * 基本的单向加密算法
 *
 * BASE64 严格地说,属于编码格式,而非加密算法<br />
 * MD5(Message Digest algorithm 5,信息摘要算法)<br />
 * SHA(Secure Hash Algorithm,安全散列算法)<br />
 * HMAC(Hash Message Authentication Code,散列消息鉴别码)<br />
 *
 * MD5、SHA、HMAC这三种加密算法，可谓是非可逆加密，就是不可解密的加密方法。我们通常只把他们作为加密的基础。单纯的以上三种的加密并不可靠。<br />
 *
 * @author Liubg
 */
public class Coder {
    public static final String KEY_MD5 = "MD5";
    public static final String KEY_SHA = "SHA";

    /** MAC算法可选以下多种算法 HmacMD5 HmacSHA1 HmacSHA256 HmacSHA384 HmacSHA512 */
    public static final String KEY_HMAC = "HmacMD5";

    /**
     * 将字符串用BASE64加密
     *
     * 按照RFC2045的定义,Base64被定义为:Base64内容传送编码被设计用来把任意序列的8位字节描述为一种不易被人直接识别的形式. <br />
     * 常见于邮件、http加密,截取http信息,你就会发现登录操作的用户名、密码字段通过BASE64加密的.<br />
     *
     * @param key
     * @return String
     */
    public static String encodeBASE64(String key) {
        return Base64.getEncoder().encodeToString(key.getBytes());
    }

    /**
     * 将字符串用BASE64加密
     *
     * @param key
     * @return String
     */
    public static String encryptBASE64(byte[] key) {
        return Base64.getEncoder().encodeToString(key);
    }

    /**
     * 将字符串用BASE64解密
     *
     * @param key
     * @return String
     * @throws IOException
     */
    public static String decodeBASE64(String key) throws IOException {
        return new String(Base64.getDecoder().decode(key));
    }

    /**
     * 将字符串用BASE64解密
     *
     * @param key
     * @return byte[]
     * @throws IOException
     */
    public static byte[] decryptBASE64(String key) throws IOException {
        return Base64.getDecoder().decode(key);
    }

    /**
     * 将字符串用MD5加密
     *
     * @param key
     * @return String
     */
    public static String encodeMD5(String key) {
        InputStream is = new ByteArrayInputStream(key.getBytes());
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance(KEY_MD5);

            byte[] buffer = new byte[2048];
            int length = -1;

            while ((length = is.read(buffer)) != -1) {
                md5.update(buffer, 0, length);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return HexFormatTransfer.toBytesHexString(md5.digest());
    }

    /**
     * 将字符串用MD5加密
     *
     * @param key
     * @return String
     * @throws NoSuchAlgorithmException
     */
    public static String encryptionMD5(String key) throws NoSuchAlgorithmException {
        return HexFormatTransfer.toBytesHexString(encryptMD5(key));
    }

    /**
     * 将字符串用MD5加密
     *
     * @param key
     * @return byte[]
     * @throws NoSuchAlgorithmException
     */
    public static byte[] encryptMD5(String key) throws NoSuchAlgorithmException {
        return encryptMD5(key.getBytes());
    }

    /**
     * 将字符串用MD5加密 (message-digest algorithm 5,信息-摘要算法)
     *
     * 广泛用于加密和解密技术,常用于文件校验.
     *
     * @param key
     * @return byte[]
     * @throws NoSuchAlgorithmException
     */
    public static byte[] encryptMD5(byte[] key) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
        md5.update(key);

        return md5.digest();
    }

    /**
     * 将字符串用SHA加密
     *
     * @param key
     * @return String
     */
    public static String encodeSHA(String key) {
        InputStream is = new ByteArrayInputStream(key.getBytes());
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance(KEY_SHA);

            byte[] buffer = new byte[2048];
            int length = -1;

            while ((length = is.read(buffer)) != -1) {
                md.update(buffer, 0, length);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return HexFormatTransfer.toBytesHexString(md.digest());
    }

    /**
     * 将字符串用SHA加密
     *
     * @param key
     * @return String
     * @throws Exception
     */
    public static String encryptionSHA(String key) throws Exception {
        return HexFormatTransfer.toBytesHexString(encryptSHA(key));
    }

    /**
     * 将字符串用SHA加密
     *
     * @param key
     * @return byte[]
     * @throws Exception
     */
    public static byte[] encryptSHA(String key) throws Exception {
        return encryptSHA(key.getBytes());
    }

    /**
     * 将字符串用SHA加密(Secure Hash Algorithm,安全散列算法)
     *
     * 数字签名等密码学应用中重要的工具,被广泛地应用于电子商务等信息安全领域.<br />
     * 虽然SHA与MD5通过碰撞法都被破解了,但是SHA仍然是公认的安全加密算法,较之MD5更为安全.<br />
     *
     * @param key
     * @return byte[]
     * @throws Exception
     */
    public static byte[] encryptSHA(byte[] key) throws Exception {
        MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
        sha.update(key);

        return sha.digest();
    }

    /**
     * 初始化HMAC密钥
     *
     * @return String
     * @throws Exception
     */
    public static String initMacKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_HMAC);

        SecretKey secretKey = keyGenerator.generateKey();
        return encryptBASE64(secretKey.getEncoded());
    }

    /**
     * HMAC加密(Hash Message Authentication Code,散列消息鉴别码)
     *
     * 基于密钥的Hash算法的认证协议.<br />
     * 消息鉴别码实现鉴别的原理是,用公开函数和密钥产生一个固定长度的值作为认证标识,用这个标识鉴别消息的完整性.<br />
     * 使用一个密钥生成一个固定大小的小数据块,即MAC,并将其加入到消息中,然后传输.接收方利用与发送方共享的密钥进行鉴别认证等.<br />
     *
     * @param data
     * @param key
     * @return byte[]
     * @throws Exception
     */
    public static byte[] encryptHMAC(byte[] data, String key) throws Exception {
        SecretKey secretKey = new SecretKeySpec(decryptBASE64(key), KEY_HMAC);
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        mac.init(secretKey);

        return mac.doFinal(data);
    }










    /**
     * MD5加密UTF-8  小写
     * @param str
     * @return String
     */
    public String getMD5UTF8(String str){
        String md5 = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(str.getBytes("utf-8"));
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; i++) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).toUpperCase().substring(1, 3));
            }
            md5 = sb.toString().toLowerCase();
        } catch (Exception e) {
        }
        return md5;
    }
    /**
     * 	MD5加密GBK
     * @param message
     * @return
     */
    public String getMD5GBK(String message){
        String md5 = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(message.getBytes("GBK"));
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; i++) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).toUpperCase().substring(1, 3));
            }
            md5 = sb.toString().toLowerCase();
        } catch (Exception e) {
        }
        return md5;
    }


    //将字符串加密成ASCII字串，如"3031209"转成"?C??@??z?O4??RR?"
    public static String EncodeMD5ASCII(String text) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(text.getBytes("US-ASCII"));
        byte[] digest = md.digest();
        return new String(digest,"US-ASCII");
    }
    //将字符串加密成MD5，32位16进制字串，如"3031209"转成"e043a49740adde7aae4f34818c52528e"
    public static String EncodeMD5Hex(String text) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(text.getBytes("US-ASCII"));
        byte[] digest = md.digest();
        StringBuffer md5 = new StringBuffer();
        for (int i = 0; i < digest.length; i++) {
            md5.append(Character.forDigit((digest[i] & 0xF0) >> 4, 16));
            md5.append(Character.forDigit((digest[i] & 0xF), 16));
        }
        return md5.toString();
    }
    //将ASCII字串编码成16进制字串,如：“?C??@??z?O4??RR?“转成”3f433f3f403f3f7a3f4f343f3f52523f“
//参数text
    //返回结果16进制字符串
    public static String DecodeMD5Hex(String text) throws Exception {
        byte[] digest = text.getBytes();
        StringBuffer md5 = new StringBuffer();
        for (int i = 0; i < digest.length; i++) {
            md5.append(Character.forDigit((digest[i] & 0xF0) >> 4, 16));
            md5.append(Character.forDigit((digest[i] & 0xF), 16));
        }
        return md5.toString();
    }

    public static void main(String args[]) throws Exception {
        String inputStr = "柳保国780426";
        System.err.println("原文字符: " + inputStr);

        String codeBASE64One = Coder.encodeBASE64(inputStr);
        String codeBASE64Two = Coder.encryptBASE64(inputStr.getBytes());

        System.err.println("BASE64 方法一加密后: " + codeBASE64One);
        System.err.println("BASE64 方法二加密后: " + codeBASE64Two);
        System.err.println("BASE64 方法一解密后: " + Coder.decodeBASE64(codeBASE64One));
        System.err.println("BASE64 方法二解密后: " + new String(Coder.decryptBASE64(codeBASE64Two)));
        System.err.println("==================================");

        System.err.println("MD5 方法一加密后: " + Coder.encodeMD5(inputStr));
        System.err.println("MD5 方法二加密后: " + Coder.encryptionMD5(inputStr));
        System.err.println("MD5 方法三加密后: " + HexFormatTransfer.toBytesHexString(Coder.encryptMD5(inputStr)));
        System.err.println("MD5 方法四加密后: " + HexFormatTransfer.toBytesHexString(Coder.encryptMD5(inputStr)));
        System.err.println("MD5 方法五加密后: " + HexFormatTransfer.toBytesHexString(Coder.encryptMD5(inputStr.getBytes())));
        System.err.println("MD5 方法六加密后: " + HexFormatTransfer.toBytesHexString(Coder.encryptMD5(inputStr.getBytes())));
        System.err.println("==================================");

        System.err.println("SHA 方法加密后: " + Coder.encodeSHA(inputStr));
        System.err.println("SHA 方法加密后: " + Coder.encryptionSHA(inputStr));
        System.err.println("SHA 方法加密后: " + HexFormatTransfer.toBytesHexString(Coder.encryptSHA(inputStr.getBytes())));
        System.err.println("SHA 方法加密后: " + HexFormatTransfer.toBytesHexString(Coder.encryptSHA(inputStr.getBytes())));
        System.err.println("==================================");

        String key = Coder.initMacKey();
        System.err.println("Mac密钥:\n" + key);

        BigInteger mac = new BigInteger(Coder.encryptHMAC(inputStr.getBytes(), key));
        System.err.println("HMAC:\n" + mac.toString(16));
    }
}
