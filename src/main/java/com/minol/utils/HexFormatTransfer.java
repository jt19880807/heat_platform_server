package com.minol.utils;

import java.io.ByteArrayOutputStream;

/**
 * 二进制、十六进制、通信格式转换
 *
 * Java和一些windows编程语言如c、c++、delphi所写的网络程序进行通讯时，需要进行相应的转换 高、低字节之间的转换。
 * windows的字节序为低字节开头 linux、unix的字节序为高字节开头java则无论平台变化，都是高字节开头。
 */
public class HexFormatTransfer {
    private static String hexStr = "0123456789ABCDEF";
    private static String[] binaryDigits = { "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111" };
    /*
	 * 将字符编码成unicode
	 */
    public static String toStrUnicode(String str) {
        StringBuilder result = new StringBuilder();

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            String hex = Integer.toHexString(chars[i]);
            result.append("\\u");
            if (hex.length() <= 2) {
                result.append("00");
            }
            result.append(hex);
        }
        return result.toString();
    }
    /*
	 * 将unicode解码成字符
	 */
    public static String toUnicodeStr(String unicodeString) {
        StringBuffer result = new StringBuffer();

        String[] hex = unicodeString.split("\\\\u");
        for (int i = 1; i < hex.length; i++) {
            result.append((char) Integer.parseInt(hex[i], 16));
        }

        return result.toString();
    }

    /*
     * 将字符编码成16进制数字,适用于所有字符(包括中文)
     */
    public static String toStrHexString(String str) {
        byte[] bytes = str.getBytes();
        StringBuilder result = new StringBuilder(bytes.length * 2);

        // 将字节数组中每个字节拆解成2位16进制整数
        for (int i = 0; i < bytes.length; i++) {
            result.append(hexStr.charAt((bytes[i] & 0xf0) >> 4));
            result.append(hexStr.charAt((bytes[i] & 0x0f) >> 0));
        }

        return result.toString();
    }

    /*
     * 将16进制数字解码成字符,适用于所有字符(包括中文)
     */
    public static String toHexStringStr(String hexString) {
        ByteArrayOutputStream out = new ByteArrayOutputStream(hexString.length() / 2);

        // 将每2位16进制整数组装成一个字节
        for (int i = 0; i < hexString.length(); i += 2) {
            out.write((hexStr.indexOf(hexString.charAt(i)) << 4 | hexStr.indexOf(hexString.charAt(i + 1))));
        }

        return new String(out.toByteArray());
    }

    /*
     * 将二进制字节数组转换为二进制字符
     */
    public static String toBytesBinaryString(byte[] bytes) {
        StringBuilder result = new StringBuilder();

        int pos = 0;
        for (byte b : bytes) {
            // 高四位
            pos = (b & 0xF0) >> 4;
            result.append(binaryDigits[pos]);
            // 低四位
            pos = b & 0x0F;
            result.append(binaryDigits[pos]);
        }

        return result.toString();
    }

    /*
     * 将二进制字节数组转换为十六进制字符
     */
    public static String toBytesHexString(byte[] bytes) {
        StringBuilder result = new StringBuilder("");

        for (int i = 0; i < bytes.length; i++) {
            result.append(toByteHexString(bytes[i]));
        }

        return result.toString();
    }
    private static String toByteHexString(byte b) {
        String hexDigits[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    /*
     * 将二进制字节数组转换为十六进制字符
     */
    public static String binaryToHexString(byte[] bytes) {
        char[] c = new char[bytes.length * 2];

        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        for (int i = 0; i < bytes.length; i++) {
            c[i * 2] = hexDigits[bytes[i] >>> 4 & 0x0f];
            c[i * 2 + 1] = hexDigits[bytes[i] & 0x0f];
        }

        return new String(c);
    }

    /*
     * 将十六进制字符转换为二进制字节数组
     */
    public static byte[] toHexStringBytes(String hexString) {
        byte[] bytes = new byte[hexString.length() / 2];// 两个字符表示一个字节，所以字节数组长度是字符串长度除以2。

        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (0xff & Integer.parseInt(hexString.substring(i * 2, i * 2 + 2), 16));
        }

        return bytes;
    }

    /*
     * 将十六进制字符转换为二进制字节数组
     */
    public static byte[] hexStringToBinary(String hexString) {
        char[] chars = hexString.toCharArray();
        byte[] bytes = new byte[chars.length / 2];

        int byteCount = 0;
        for (int i = 0; i < chars.length - 1; i += 2) {
            byte newByte = 0x00;
            newByte |= hexCharToByte(chars[i]);
            newByte <<= 4;
            newByte |= hexCharToByte(chars[i + 1]);

            bytes[byteCount] = newByte;

            byteCount++;
        }

        return bytes;
    }

    private static final byte hexCharToByte(char c) {
        switch (c) {
            case '0':
                return 0x00;
            case '1':
                return 0x01;
            case '2':
                return 0x02;
            case '3':
                return 0x03;
            case '4':
                return 0x04;
            case '5':
                return 0x05;
            case '6':
                return 0x06;
            case '7':
                return 0x07;
            case '8':
                return 0x08;
            case '9':
                return 0x09;
            case 'a':
                return 0x0A;
            case 'b':
                return 0x0B;
            case 'c':
                return 0x0C;
            case 'd':
                return 0x0D;
            case 'e':
                return 0x0E;
            case 'f':
                return 0x0F;
        }
        return 0x00;
    }

    /*
     * 将int转换为占四个字节的byte数组(低字节在前，高字节在后)
     */
    public static byte[] toLH(int value) {
        byte[] bytes = new byte[4];

        bytes[0] = (byte) (value & 0xff);
        bytes[1] = (byte) (value >> 8 & 0xff);
        bytes[2] = (byte) (value >> 16 & 0xff);
        bytes[3] = (byte) (value >> 24 & 0xff);

        return bytes;
    }

    /*
     * byte数组中取int数值，本方法适用于(低字节在前，高字节在后)的顺序， 从数组的第offset位开始 ，和toLH()配套使用
     */
    public static int toLHInt(byte[] bytes, int offset) {
        int value;
        value = (int) ((bytes[offset] & 0xFF) | ((bytes[offset + 1] & 0xFF) << 8) | ((bytes[offset + 2] & 0xFF) << 16) | ((bytes[offset + 3] & 0xFF) << 24));
        return value;
    }
    /*
     * byte数组中取int数值，本方法适用于(低字节在前，高字节在后)的顺序，从数组的第offset位开始，和toLH()配套使用
     */
    public static int toLHInt_1(byte[] bytes, int offset) {
        int value;
        value = (int) ((bytes[offset] & 0xFF) | ((bytes[offset + 1] << 8) & 0xFF00) | ((bytes[offset + 2] << 16) & 0xFF0000) | ((bytes[offset + 3] << 24) & 0xFF000000));
        return value;
    }

    /*
     * 将int转换为占四个字节的byte数组(高字节在前，低字节在后)
     */
    public static byte[] toHH(int value) {
        byte[] bytes = new byte[4];

        bytes[3] = (byte) (value & 0xff);
        bytes[2] = (byte) (value >> 8 & 0xff);
        bytes[1] = (byte) (value >> 16 & 0xff);
        bytes[0] = (byte) (value >> 24 & 0xff);

        return bytes;
    }

    /*
     * byte数组中取int数值，本方法适用于(高字节在前，低字节在后)的顺序，从数组的第offset位开始，和toHH()配套使用
     */
    public static int toHHInt(byte[] src, int offset) {
        int value;
        value = (int) (((src[offset] & 0xFF) << 24) | ((src[offset + 1] & 0xFF) << 16) | ((src[offset + 2] & 0xFF) << 8) | (src[offset + 3] & 0xFF));
        return value;
    }

    /*
     * 将short转为低字节在前，高字节在后的byte数组
     */
    public static byte[] toLH(short value) {
        byte[] bytes = new byte[2];

        bytes[0] = (byte) (value & 0xff);
        bytes[1] = (byte) (value >> 8 & 0xff);

        return bytes;
    }

    /*
     * 将short转为高字节在前，低字节在后的byte数组
     */
    public static byte[] toHH(short value) {
        byte[] bytes = new byte[2];

        bytes[1] = (byte) (value & 0xff);
        bytes[0] = (byte) (value >> 8 & 0xff);

        return bytes;
    }

    /*
     * 将float转为低字节在前，高字节在后的byte数组
     */
    public static byte[] toLH(float value) {
        return toLH(Float.floatToRawIntBits(value));
    }

    /*
     * 将float转为高字节在前，低字节在后的byte数组
     */
    public static byte[] toHH(float value) {
        return toHH(Float.floatToRawIntBits(value));
    }

    /*
     * 将高字节数组转换为int
     */
    public static int toBytesHexhInt(byte[] bytes) {
        int s = 0;
        for (int i = 0; i < 3; i++) {
            if (bytes[i] >= 0) {
                s = s + bytes[i];
            } else {
                s = s + 256 + bytes[i];
            }
            s = s * 256;
        }
        if (bytes[3] >= 0) {
            s = s + bytes[3];
        } else {
            s = s + 256 + bytes[3];
        }
        return s;
    }

    /*
     * 将低字节数组转换为int
     */
    public static int toBytesHexlInt(byte[] bytes) {
        int s = 0;
        for (int i = 0; i < 3; i++) {
            if (bytes[3 - i] >= 0) {
                s = s + bytes[3 - i];
            } else {
                s = s + 256 + bytes[3 - i];
            }
            s = s * 256;
        }
        if (bytes[0] >= 0) {
            s = s + bytes[0];
        } else {
            s = s + 256 + bytes[0];
        }
        return s;
    }

    /*
     * 高字节数组到short的转换
     */
    public static short toBytesHexhShort(byte[] bytes) {
        int s = 0;
        if (bytes[0] >= 0) {
            s = s + bytes[0];
        } else {
            s = s + 256 + bytes[0];
        }
        s = s * 256;
        if (bytes[1] >= 0) {
            s = s + bytes[1];
        } else {
            s = s + 256 + bytes[1];
        }
        short result = (short) s;
        return result;
    }

    /*
     * 低字节数组到short的转换
     */
    public static short toBytesHexlShort(byte[] bytes) {
        int s = 0;
        if (bytes[1] >= 0) {
            s = s + bytes[1];
        } else {
            s = s + 256 + bytes[1];
        }
        s = s * 256;
        if (bytes[0] >= 0) {
            s = s + bytes[0];
        } else {
            s = s + 256 + bytes[0];
        }
        short result = (short) s;
        return result;
    }

    /*
     * 高字节数组转换为float
     */
    public static float toBytesHexhFloat(byte[] bytes) {
        int i = ((((bytes[0] & 0xff) << 8 | (bytes[1] & 0xff)) << 8) | (bytes[2] & 0xff)) << 8 | (bytes[3] & 0xff);

        return Float.intBitsToFloat(i);
    }

    /*
     * 低字节数组转换为float
     */
    public static float toBytesHexlFloat(byte[] bytes) {
        int i = ((((bytes[3] & 0xff) << 8 | (bytes[2] & 0xff)) << 8) | (bytes[1] & 0xff)) << 8 | (bytes[0] & 0xff);

        return Float.intBitsToFloat(i);
    }

    /*
     * 将byte数组中的元素倒序排列
     */
    public static byte[] bytesReverseOrder(byte[] bytes) {
        int length = bytes.length;
        byte[] result = new byte[length];

        for (int i = 0; i < length; i++) {
            result[length - i - 1] = bytes[i];
        }

        return result;
    }

    /*
     * 将int类型的值转换为字节序颠倒过来对应的int值
     */
    public static int reverseInt(int i) {
        return toBytesHexhInt(toLH(i));
    }

    /*
     * 将short类型的值转换为字节序颠倒过来对应的short值
     */
    public static short reverseShort(short s) {
        return toBytesHexhShort(toLH(s));
    }

    /*
     * 将float类型的值转换为字节序颠倒过来对应的float值
     */
    public static float reverseFloat(float f) {
        return toBytesHexhFloat(toLH(f));
    }

    public static void main(String[] args) throws Exception {
        String str = "二进制与十六进制互转测试";

        System.out.println("字符编码成16进制数字：" + toStrHexString(str));
        System.out.println("16进制数字解码成字符：" + toHexStringStr(toStrHexString("123321")));

        System.out.println("将二进制字节数组转换为二进制字符 ：" + toBytesBinaryString(str.getBytes()));

        System.out.println("将二进制字节数组转换为十六进制字符：" + toBytesHexString(str.getBytes()));
        System.out.println("将十六进制字符转换为二进制字节数组：" + toHexStringBytes(toBytesHexString(str.getBytes())));
    }

}
