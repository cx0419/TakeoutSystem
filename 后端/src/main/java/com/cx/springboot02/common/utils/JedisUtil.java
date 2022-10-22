package com.cx.springboot02.common.utils;

/**
 * web安装时用的
 */
public class JedisUtil {
//
//    //服务器地址
//    private static final String host = "127.0.0.1";
//    //端口
//    private static final int port = 6379;
//    //密码
//    private static final String password = null;
//    //超时时间
//    private static final String timeout = "10000";
//    //最大连接数
//    private static final int maxTotal = 1024;
//    //最大连接阻塞等待时间
//    private static final String maxWaitMillis = "10000ms";
//    //最大空闲连接
//    private static final int maxIdle = 200;
//    //最小空闲连接
//    private static final int minIdle = 5;
//
//    public static JedisPool redisPoolFactory() {
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        jedisPoolConfig.setMaxWaitMillis(Long.parseLong(maxWaitMillis.substring(0,
//                maxWaitMillis.length() - 2)));
//        jedisPoolConfig.setMaxTotal(maxTotal);
//        jedisPoolConfig.setMaxIdle(maxIdle);
//        jedisPoolConfig.setMinIdle(minIdle);
//        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port,
//                Integer.parseInt(timeout.substring(0, timeout.length() - 2)), password);
//        return jedisPool;
//    }
//
//    public static void main(String[] args) {
//        JedisPool jedisPool = JedisUtil.redisPoolFactory();
//        Jedis jedis = null;
//
//        jedis = jedisPool.getResource();
//       // System.out.println(jedis.hkeys(key));
//
//        jedis.flushDB();
//
//        if (jedis != null){
//            jedis.close();   // 关闭jedis，释放资源
//        }
//
//    }
//
//    public static void closeJedis(Jedis jedis){
//        if(jedis != null){
//            jedis.close();
//        }
//    }

}