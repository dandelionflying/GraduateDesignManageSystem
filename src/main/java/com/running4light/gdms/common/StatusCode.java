package com.running4light.gdms.common;
/*
 *  状态码实体类
 */
public class StatusCode {
    public static final int OK=20000;//请求成功
    public static final int ERROR =20001;//请求失败
    public static final int LOGINERROR =20002;//用户名或密码错误
    public static final int ACCESSERROR =20003;//权限不足
    public static final int REMOTEERROR =20004;//远程调用失败
    public static final int REPERROR =20005;//重复操作
    public static final int EMPTYERROR =20006;//空记录
}
