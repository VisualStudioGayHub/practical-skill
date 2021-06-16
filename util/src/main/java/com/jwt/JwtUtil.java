package com.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Map;

/**
 * @Author: zsg
 * @Date: 2020/12/23
 */
public class JwtUtil {


    /**
     * 解析JWT
     */
    private static DecodedJWT getJwt(String jwtToken) {
        return JWT.decode(jwtToken);
    }

    /**
     * 已字典方式获取Token中携带的信息
     *
     * @param keyIndex 对应键值 platform_info
     * @param jwtToken token值
     * @return
     */
    public static Map<String, Object> getPayLoadMap(String keyIndex, String jwtToken) {
        DecodedJWT jwt = getJwt(jwtToken);
        return jwt.getClaim(keyIndex).asMap();
    }

    /**
     * 已字符串形式获取token中携带的值
     *
     * @param keyIndex 对应键值 open_id
     * @param jwtToken token值
     * @return
     */
    public static String getPayLoadString(String keyIndex, String jwtToken) {
        DecodedJWT jwt = getJwt(jwtToken);
        return jwt.getClaim(keyIndex).asString();
    }

    /**
     * 已数字形式获取token中携带的值
     *
     * @param keyIndex 对应键值 id
     * @param jwtToken token值
     * @return
     */
    public static Integer getPayLoadInteger(String keyIndex, String jwtToken) {
        DecodedJWT jwt = getJwt(jwtToken);
        return jwt.getClaim(keyIndex).asInt();
    }
}
