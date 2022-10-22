package com.cx.springboot02.common.utils;



import com.cx.springboot02.pojo.Customer;
import com.cx.springboot02.pojo.CustomerService;
import com.cx.springboot02.service.ICustomerService;
import com.cx.springboot02.service.impl.CustomerServiceImpl;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtUtils {

    @Autowired
    RedisOperator redisOperator;

    @Autowired
    ICustomerService iCustomerService;

    /**
     * 01为登录token时效期
     * 01为验证码时效期
     */
    private static final long EXPIRE_TIME01 =30*60*1000;
    private static final long EXPIRE_TIME02=60*1000;
    private static final long EXPIRE_TIME03= 30L*24*60*60*1000;
    /**
     * 加密密钥
     */
    private static final String KEY = "chenxiang";

    /**
     * 生成账号密码的token
     *
     * @return
     */
    public String createToken(String name,String password){
        Map<String,Object> header = new HashMap<>();
        Map<String,Object> Claims = new HashMap<>();

        Claims.put("name", name);
        Claims.put(("password"), password);

        header.put("typ","JWT");
        header.put("alg","HS256");
        //setID:用户ID
        //setExpiration:token过期时间  当前时间+有效时间
        //setSubject:用户名
        //setIssuedAt:token创建时间
        //signWith:加密方式
        JwtBuilder builder = Jwts.builder()
                .setClaims(Claims)
                .setHeader(header)
                .setId(name)
                .setExpiration(new Date(System.currentTimeMillis()+ EXPIRE_TIME03))
                .setSubject(name)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,KEY);
        return builder.compact();
    }

    /**
     * 验证token是否有效
     * @param token  请求头中携带的token
     * @return  token验证结果  2-token过期；1-token认证通过；0-token认证失败
     */
    public Customer verify(String token){
        if(token==null){
            return null;
        }
        Claims claims = null;
        try {
            //token过期后，会抛出ExpiredJwtException 异常，通过这个来判定token过期，
            claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
        }catch (ExpiredJwtException e){
          return null;
        }
        //从token中获取用户name，在服务器的map当查询是否当前用户是否token有效
        String name = claims.get("name", String.class);
        String token2 = redisOperator.get(name);
        if(token2!=null && token2.equals(token)){
            Customer customer = iCustomerService.selectCustomerByName(name);
            return customer;
        }else{
            return null;
        }
    }

    /**
     * 获取jwt-token里面的值
     * @param token
     * @param key
     * @return
     */
    public static String getValue(String token,String key){
        if(token==null){
            return null;
        }
        Claims claims = null;
        try {
            //token过期后，会抛出ExpiredJwtException 异常，通过这个来判定token过期，
            System.out.println("token:"+token);
            claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
        }catch (ExpiredJwtException | MalformedJwtException e){
            return null;
        }
        //从token中获取用户name，在服务器的map当查询是否当前用户是否token有效
        return claims.get(key, String.class);
    }
}
