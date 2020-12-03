package com.ypn.until;

import com.ypn.entity.Dept;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ypn
 * @date 2020/8/6
 * @motto I raise pigs in your field
 * @desc
 */
public class SystemStringUtils extends StringUtils {
    //判断是否为字符串
    public static boolean isString(Object o) {
        Boolean b = o.getClass().getName().equals("java.lang.String");
        return b;
    }

    public static String bigToSmall(String str) {
        String big = str.toUpperCase();
        String small = str.toLowerCase();
        StringBuffer sb = new StringBuffer(str.length());
        for (int i = 0; i < str.length(); i++) {
            if (big.charAt(i) == str.charAt(i)) {
                sb.append(small.charAt(i));
            } else {
                sb.append(big.charAt(i));
            }
        }
        return sb.toString();
    }

    /**
     * 获取当前系统时间
     *
     * @return
     */
    public static String nowDate() {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        return df.format(date);
    }

    public static void main(String[] args) {
        System.out.println(nowDate());
    }
}

