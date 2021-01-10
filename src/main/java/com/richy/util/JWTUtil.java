package com.richy.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.richy.config.JWTConfig;
import com.richy.constants.JWTConstant;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * TODO
 * JWT工具类
 * @author Richy
 * @date 2021-01-10 17:33
 */
public class JWTUtil {

    private final static Logger logger = LoggerFactory.getLogger(JWTUtil.class);
    private static String secret;
    private static Integer cookieMaxAge;
    private static String cookiePath;
    private static String domain;

    static{
        JWTConfig jwtConfig = SpringContextUtil.getBean(JWTConfig.class);
        secret = jwtConfig.getSecret();
        if(StringUtils.isNotBlank(jwtConfig.getCookiemaxage())){
            logger.info("cookieMaxAge:{}",jwtConfig.getCookiemaxage());
            cookieMaxAge = Integer.valueOf(jwtConfig.getCookiemaxage());
        }
        cookiePath = jwtConfig.getCookiePath();
        domain = jwtConfig.getDomain();
    }

    /**
     * @desc:
     * 创建token
     * @method: createToken
     * @param:	username: 用户名（工号）
     * @date:   2021-01-10 17:54
     * @return: java.lang.String
     */
    public static String createToken(String username){
        try{
            //过期时间转换成毫秒
            Integer millisSecond = cookieMaxAge * 1000;
            JWTCreator.Builder builder = JWT
                    .create()
                    .withIssuer(username)//用户工号
                    .withExpiresAt(new Date(System.currentTimeMillis() + millisSecond));//过期时间
            String token = builder.sign(Algorithm.HMAC256(secret));//秘钥
            return token;
        }catch (Exception e){
            logger.error("JWTUtil-createToken error:",e);
        }
        return null;
    }

    /**
     * @desc:
     * 校验token，并获取用户信
     * @method: verifyToken
     * @param:	token: token，由前端传递
     * @date:   2021-01-10 18:11
     * @return: java.lang.String
     */
    public static String verifyToken(String token){
        try{
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secret)).build();
            DecodedJWT jwt = jwtVerifier.verify(token);//校验token
            String username = jwt.getIssuer();//获取token中的用户信息
            return username;
        }catch (Exception e){
            logger.error("JWTUtil-verifyToken error:",e);
        }
        return null;
    }


    /**
     * @desc:
     * 获取cookie
     * @method: getCookie
     * @param:	request:
     * @param:	key:
     * @date:   2021-01-10 18:15
     * @return: java.lang.String
     */
    public static String getCookie(HttpServletRequest request,String key){
        String cookie = null;
        Cookie[] cookies = request.getCookies();
        for(int i=0;cookies != null && i < cookies.length;i++){
            Cookie c = cookies[i];
            if(StringUtils.equals(c.getName(),key)){
                cookie = c.getValue();
            }
        }
        return cookie;
    }

    /**
     * @desc:
     * 创建cookie
     * @method: buildCookie
     * @param:	token:
     * @date:   2021-01-10 18:28
     * @return: javax.servlet.http.Cookie
     */
    public static Cookie buildCookie(String token){
        Cookie cookie = new Cookie(JWTConstant.TOKEN_COOKIE_KEY,token);
        cookie.setMaxAge(cookieMaxAge);
        cookie.setPath(cookiePath);
        cookie.setDomain(domain);
        return cookie;
    }

    /**
     * @desc:
     * 响应信息添加cookie
     * @method: setCookie
     * @param:	response:
     * @param:	key:
     * @param:	value:
     * @date:   2021-01-10 18:23
     * @return: void
     */
    public static void setCookie(HttpServletResponse response,String key,String value){
        Cookie cookie = new Cookie(key,value);
        cookie.setMaxAge(cookieMaxAge);
        cookie.setPath(cookiePath);
        cookie.setDomain(domain);
        response.addCookie(cookie);
    }

    public static String getSecret() {
        return secret;
    }

    public static void setSecret(String secret) {
        JWTUtil.secret = secret;
    }

    public static Integer getCookieMaxAge() {
        return cookieMaxAge;
    }

    public static void setCookieMaxAge(Integer cookieMaxAge) {
        JWTUtil.cookieMaxAge = cookieMaxAge;
    }
}
