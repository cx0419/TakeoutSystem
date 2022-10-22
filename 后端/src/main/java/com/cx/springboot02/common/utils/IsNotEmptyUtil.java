package com.cx.springboot02.common.utils;
/*
 *@Author: 陈翔
 * @Date: 2020年12月30日 14时29分15秒
 * @Version 1.0
 * @Description:    非空判断
 */
public class IsNotEmptyUtil {
    public static boolean isEmpty(Object object) {
        if (object == null) {
            return (true);
        }
        if ("".equals(object)) {
            return (true);
        }
        if ("null".equals(object)) {
            return (true);
        }
        return (false);
    }
 
    public static boolean isNotEmpty(Object object) {
        if (object != null && !object.equals("") && !object.equals("null")) {
            return (true);
        }
        return (false);
    }
}