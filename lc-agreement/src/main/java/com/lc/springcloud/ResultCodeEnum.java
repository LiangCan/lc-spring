package com.lc.springcloud;

/**
 * Created by Administrator on 2018/8/21.
 */
public enum ResultCodeEnum {
    /**
     * 未知系统错误  0
     */
    SYSTEM_ERROR("0", "system.error"),

    /**
     * 成功  1
     */
    SUCCESS("1", "system.sucess"),
    /**
     * 缺少必备参数  10001
     */
    PARAM_MISS("10001", "valid.param_miss"),
    /**
     * 参数长度错误  10002
     */
    PARAM_VALUE_LENGTH("10002", "valid.param_value_length_error"),
    /**
     * 参数值错误 10003
     */
    PARAM_VALUE_INVALID("10003", "valid.param_value_invalid"),
    /**
     * 参数格式错误  10004
     */
    PARAM_FORMAT_ERROR("10004", "valid.param_format_error"),
    /**
     * 协议版本过低，请升级   10005
     */
    PARAM_AGREEMENT_ERROR("10005", "valid.param_agreement_error"),
    /**
     * http请求类型错误   10006
     */
    PARAM_HTTP_REQ_TYPE_ERROR("10006", "valid.param_http_req_type_error"),
    /**
     * 登录token无效   10100
     */
    API_LOGIN_TOKEN_INVALID("10100", "api.login_token_invalid"),

    /**
     * 邮箱发送频繁 24小时后重试   10101
     */
    API_PUSH_EMAIL_INVALID("10101", "api.push_email_invalid"),
    /**
     * 数据不存在   10102
     */
    API_DATA_IS_NULL("10102", "api.data_is_null"),
    /**
     * 数据已经存在   10103
     */
    API_DATA_IS_NOT_NULL("10103", "api.data_is_not_null"),
    /**
     * 用户对 XX 权限不够  10104
     */
    API_USER_JURISDICTION_ERROR("10104", "api.user_jurisdiction_error"),
    /**
     * 创建的智能会形成闭环 10105
     */
    API_CREATE_WISDOM_ERROR("10105", "api.create_wisdom_error"),

    /**
     * 设备不在线   20000
     */
    DEVICE_IS_OFF_LINE("20000", "device.is_off_line"),
    /**
     * 设备响应指令超时   20001
     */
    MSG_NOT_RESPONSE("20001", "device.msg_not_response"),
    /**
     * 服务宕机了  30000
     */
    SERVER_ERROR("30000", "ser.server_error"),
    /**
     * 第三方服务器异常 30001
     */
    THIRD_PARTY_SERVER_ERROR("30001", "ser.third_party_server_error"),
    /**
     * 发送设备失败   30002
     */
    PUSH_MSG_ERROR("30002", "ser.push_msg_fail");

    ResultCodeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public  String key;

    public  String value;

    public String getKey() {
        return key;
    }

    public Integer getIntKey() {
        return Integer.parseInt(key);
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
