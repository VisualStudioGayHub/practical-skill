package com.jwt;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author: zsg
 * @Date: 2020/12/23
 */
public class AuthorizationAdminInfo {

    /**
     * 获取用户手机号
     */
    public static String getUserPhone() {
        Object userPhone;
        try {
            userPhone = JwtUtil.getPayLoadString("phone", getToken());
        } catch (Exception ignore) {
            userPhone = "";
        }
        return BZValue.stringValue(userPhone);
    }

    /**
     * 获取用户角色
     */
    public static String getRoleName() {
        Object roleName;
        try {
            roleName = JwtUtil.getPayLoadString("roleName", getToken());
        } catch (Exception ignore) {
            roleName = "";
        }
        return BZValue.stringValue(roleName);
    }

    /**
     * 获取用户角色id
     */
    public static String getRoleIds() {
        Object roleIds;
        try {
            roleIds = JwtUtil.getPayLoadString("roleIds", getToken());
        } catch (Exception ignore) {
            roleIds = "";
        }
        return BZValue.stringValue(roleIds);
    }

    /**
     * 获取用户账号名称
     */
    public static String getName() {
        Object name;
        try {
            name = JwtUtil.getPayLoadString("name", getToken());
        } catch (Exception ignore) {
            name = "10000";
        }
        return BZValue.stringValue(name);
    }

    /**
     * 获取用户昵称
     */
    public static String getNickName() {
        String token = getToken();
        safeVerify(token);
        Object contactName;
        try {
            contactName = JwtUtil.getPayLoadString("nickName", token);
        } catch (Exception ignore) {
            contactName = "";
        }
        return BZValue.stringValue(contactName);
    }

    public static String getContactPhone() {
        String token = getToken();
        safeVerify(token);
        Object contactPhone;
        try {
            contactPhone = JwtUtil.getPayLoadString("contactPhone", token);
        } catch (Exception ignore) {
            contactPhone = "";
        }
        return BZValue.stringValue(contactPhone);
    }

    public static String getToken() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return "";
        }
        HttpServletRequest request = requestAttributes.getRequest();
        return request.getHeader("Authorization");
    }

    /*public static Map<String, Object> getPlatformInfo(String jwtToken) {
        Map<String, Object> platformInfo = JwtUtil.getPayLoadMap("platform_info", jwtToken);
        if (CollectionUtils.isEmpty(platformInfo)) {
            throw new IllegalStateException("无用户信息");
        }
        return platformInfo;
    }

    public static Map<String, Object> getShopInfo(String jwtToken) {
        Map<String, Object> platformInfo = JwtUtil.getPayLoadMap("shop_info", jwtToken);
        if (CollectionUtils.isEmpty(platformInfo)) {
            throw new IllegalStateException("无店铺信息");
        }
        return platformInfo;
    }
*/

    public static Long getUserId() {
        String token = getToken();
        safeVerify(token);
        Object object;
        try {
            object = JwtUtil.getPayLoadInteger("id", token);
        } catch (Exception ignore) {
            object = "";
        }
        return BZValue.longValue(object);
    }

    private static void safeVerify(String token) {
        Integer iat = 0;
        try {
            iat = JwtUtil.getPayLoadInteger("iat", token);
        } catch (Exception ignore) {
        }
        if (iat != 0 && iat < 1560184200) {
            throw new BusinessException(ResultCode.USER_NOT_LOGGED_IN);
        }
    }

    /*
    public static String getUserId() {
        Object userId;
        try {
            userId = getPlatformInfo(getToken()).get("user_id");
        } catch (Exception ignore) {
            userId = getAppUserId();
        }

        return BZValue.stringValue(userId);
    }*/

    public static String getUserName() {
        Object username;
        try {
            username = getPlatformInfo(getToken()).get("username");
        } catch (Exception ignore) {
            username = getUserPhone();
        }
        String s = BZValue.stringValue(username);
        if (StringUtils.isEmpty(s)) {
            s = getUserPhone();
        }
        return s;
    }

    /*public static String getUserPhone() {
        Object phone;
        try {
            phone = getPlatformInfo(getToken()).get("phone");
        } catch (Exception ignore) {
            phone = getAppUserPhone();
        }
        return BZValue.stringValue(phone);
    }*/

    public static String getUserCode() {
        String token = getToken();
        safeVerify(token);
        Object customerCode;
        try {
            customerCode = JwtUtil.getPayLoadString("customerCode", token);
        } catch (Exception ignore) {
            customerCode = "";
        }
        return BZValue.stringValue(customerCode);
    }

    public static Map<String, Object> getPlatformInfo(String jwtToken) {
        Map<String, Object> platformInfo = JwtUtil.getPayLoadMap("platform_info", jwtToken);
        if (CollectionUtils.isEmpty(platformInfo)) {
            throw new IllegalStateException("无用户信息");
        }
        return platformInfo;
    }

}
