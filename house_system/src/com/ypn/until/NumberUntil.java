package com.ypn.until;

/**
 * @author ypn
 * @date 2020/8/14
 * @motto I raise pigs in your field
 * @desc
 */
public class NumberUntil {
    /**
     * 字符串转Integer
     *
     * @param o
     * @param def 默认值
     * @return
     */
    public static int getIntegerValue(Object o, int def) {
        return getInteger(o, def);
    }

    public static Integer getInteger(Object o, int def) {
        String str = o == null ? "" : o.toString();
        Integer i = null;
        if (str.trim().length() == 0) {
            i = def;
        } else {
            i = Integer.valueOf(str);
        }
        return i == null ? new Integer(def) : i;
    }

    /**
     * int转字符串
     * @param num
     * @return
     */
    public static String numStr(Object num) {
        if (num.toString().trim() != null) {
            return String.valueOf(num).toString();
        } else {
            return "";
        }
    }
}
