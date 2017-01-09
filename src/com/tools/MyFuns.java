package com.tools;

import java.io.UnsupportedEncodingException;

/**
 * Created by junlai on 2017/1/6.
 */
public class MyFuns {
    public static String convert2utf8(String s) {
        if (s == null) {
            return null;
        } else {
            try {
                s = new String(s.getBytes("iso-8859-1"), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return s;
    }
}
