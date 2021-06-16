package com.jwt;

import org.springframework.util.NumberUtils;

import java.util.Collections;
import java.util.List;

/**
 * @Author: zsg
 * @Date: 2020/12/23
 */
final public class BZValue {

    public static Short shortValue(Object object) {
        try {
            return NumberUtils.parseNumber(stringValue(object), Short.class);
        } catch (Exception e) {
            return 0;
        }
    }

    public static Integer intValue(Object object) {
        try {
            return NumberUtils.parseNumber(stringValue(object), Integer.class);
        } catch (Exception e) {
            return 0;
        }
    }

    public static Long longValue(Object object) {
        try {
            return NumberUtils.parseNumber(stringValue(object), Long.class);
        } catch (Exception e) {
            return 0L;
        }
    }

    public static Float floatValue(Object object) {
        try {
            return NumberUtils.parseNumber(stringValue(object), Float.class);
        } catch (Exception e) {
            return 0F;
        }
    }

    public static Double doubleValue(Object object) {
        try {
            return NumberUtils.parseNumber(stringValue(object), Double.class);
        } catch (Exception e) {
            return 0.00;
        }
    }

    public static Boolean boolValue(Object object) {
        return Boolean.valueOf(stringValue(object));
    }

    public static String stringValue(Object object) {
        if (object == null) {
            return "";
        }
        return String.valueOf(object);
    }

    public static List listValue(Object object) {
        if (object instanceof List) {
            return (List) object;
        }
        return Collections.EMPTY_LIST;
    }
}
