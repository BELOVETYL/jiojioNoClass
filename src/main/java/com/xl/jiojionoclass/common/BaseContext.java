package com.xl.jiojionoclass.common;

/**
 * 基于ThreadLocal封装工具类，用户保存和获取当前登录用户id
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();
    private static ThreadLocal<Object> threadLocalObject = new ThreadLocal<>();
    public static void setToken(String token){threadLocalObject.set(token);}
    public static String getToken(){
        return (String) threadLocalObject.get();}
    /**
     * 设置值
     * @param id
     */
    public static void setCurrentId(Long id){
        threadLocal.set(id);
    }


    /**
     * 获取值
     * @return
     */
    public static Long getCurrentId(){
        return threadLocal.get();
    }
}