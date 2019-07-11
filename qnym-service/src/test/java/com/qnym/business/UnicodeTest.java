package com.qnym.business;

import java.io.UnsupportedEncodingException;

/**
 * 斜杠三个数字 两个组成字符 可能是gbk 的8进制编码 \304\***
 */

public class UnicodeTest {

    public static String toOct(String s)throws Exception
    {
        String result = "";
        byte[] bytes = s.getBytes("gbk");
        for (byte b : bytes)
        {
            int b1 = b;
            if (b1 < 0) b1 = 256 + b1;
            result += "\\" + (b1 / 64) % 8 +  "" + (b1 / 8) % 8 + "" + b1 % 8;
        }
        return result;
    }

    public static String getOct(String s) throws UnsupportedEncodingException
    {
        String[] as = s.split("\\\\");
        byte[] arr = new byte[as.length - 1];
        for (int i = 1; i < as.length; i++)
        {
            int sum = 0;
            int base = 64;
            for (char c : as[i].toCharArray())
            {
                sum += base * ((int)c - '0');
                base /= 8;
            }
            if (sum >= 128) sum = sum - 256;
            arr[i - 1] = (byte)sum;
        }
        return new String(arr,"gbk"); //如果还有乱码，这里编码方式你可以修改下，比如试试看unicode gbk等等
    }

    public static void main(String[] args) throws Exception {
        String s = "\\你";
        String o = toOct(s);
        System.out.println(o);
        s = getOct(o);
        System.out.println(s);
    }
}
