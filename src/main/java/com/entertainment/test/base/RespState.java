package com.entertainment.test.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 常规的api请求返回
 *
 */
public enum RespState {
    //状态完全正常
    ok(0),
    //错误的加密密钥
    badSecurity(1),
    //错误的用户认证信息
    badAuthor(2),
    //已发货
    badParams(3),
    //其他抛出错误
    exception(4),
    //其他抛出错误
    notExist(5);

    private int value;
    private static Map<Integer, RespState> map = new HashMap<>();

    private RespState(int value) {
        this.value = value;
    }

    static {
        for (RespState pageType : RespState.values()) {
            map.put(pageType.value, pageType);
        }
    }

    public static RespState valueOf(int pageType) {
        return (RespState) map.get(pageType);
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        switch (this) {
            case ok:
                return "ok";
            case badSecurity:
                return "加密密钥或加密签名不正确";
            case badAuthor:
                return "用户认证信息不正确";
            case badParams:
                return "请求参数错误";
            case exception:
                return "运行错误";
            case notExist:
                return "查找的对象不存在";
            default:
                return "";

        }
    }
}
