package com.entertainment.test.base;


/**
 * 通用数据返回封装
 *
 */

public class RespEntity<T> {

    /**
     * 创建一个对象，以ok的状态
     *
     * @return 结果信息
     */
    public static <T> RespEntity<T> One() {
        return new RespEntity<>();
    }

    /**
     * 需要返回加密数据的调用
     *
     * @param req 请求
     * @return 结果对象
     */
//    public static <T> RespEntity<T> One(BaseReq req) {
//        RespEntity<T> respEntity = new RespEntity<>();
//        respEntity.obscure = true;
//        respEntity.security = req.getSecurity();
//        return respEntity;
//    }

    /**
     * 根据错误状态创建对象
     *
     * @param state 状态
     * @return 结果对象
     */
    public static <T> RespEntity<T> One(RespState state) {
        RespEntity<T> respEntity = new RespEntity<>();
        respEntity.code = state;
        return respEntity;
    }

    /**
     * 执行的状态
     */
    public RespState code = RespState.ok;

    /**
     * 附加消息，
     */
    public String message = "ok";

    /**
     * 数据是否加密压缩
     */
    public Boolean obscure = false;

    /**
     * 当前过程中使用到的aesKey
     */
    public String security = "";

    /**
     * 正常返回的数据体
     */
    public T data;

    public int getCode() {
        return code.getValue();
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public Boolean getObscure() {
        return obscure;
    }
}
