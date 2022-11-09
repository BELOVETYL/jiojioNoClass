package com.xl.jiojionoclass.config;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Data
public class JwtConfig {
    /**
     * 生成token的秘钥
     */
    @Value("${jwt.TOKEN_KEY}")
    private String TOKEN_KEY;
    /**
     * token颁布者
     */
    @Value("${jwt.ISSure}")
    private String ISSure;
    /**
     * token有效期2小时
     */
    @Value("${jwt.TOKEN_TIMEOUT}")
    private int TOKEN_TIMEOUT;
    /**
     * 生成token
     *
     * @param claims 要放入token中的信息
     */
    public String create(Map<String, String> claims) {
        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("alg", "HS256");
        headerMap.put("typ", "JWT");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.HOUR_OF_DAY, TOKEN_TIMEOUT);
        JWTCreator.Builder builder = JWT.create()
                .withHeader(headerMap)
                .withIssuer(ISSure)   //发布者
                .withIssuedAt(new Date())   //生成签名的时间
                .withExpiresAt(c.getTime());//token有效期
        //插入值
        for (String key : claims.keySet()) {
            builder.withClaim(key, claims.get(key));
        }
        //使用HS256加密算法生成token
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_KEY);
        String token = builder.sign(algorithm);
        return token;
    }

    /**
     * 验证token是否有效
     */
    public   boolean verifierToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_KEY);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(ISSure) //匹配指定的token发布者 auth0
                    .build();
            DecodedJWT jwt = verifier.verify(token); //解码JWT ，verifier 可复用

            return true;
        } catch (JWTVerificationException e) {
            //无效的签名/声明
            System.out.println("验证的token无效");
            return false;
        }
    }


    /**
     * 获取token中放入的信息
     */
    public  Map<String,Object> getTokenInfo(String token,String type) {
        Map<String, Claim> map = null;

        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_KEY);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(ISSure) //匹配指定的token发布者 auth0
                    .build();
            DecodedJWT jwt = verifier.verify(token);

            map = jwt.getClaims();
        } catch (JWTVerificationException e) {
            //无效的签名/声明
            System.out.println("验证的token无效");
            e.printStackTrace();
        }
        return map.get(type).asMap();
    }
}


