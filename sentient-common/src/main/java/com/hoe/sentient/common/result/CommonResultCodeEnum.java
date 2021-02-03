package com.hoe.sentient.common.result;

/**
 * 通用异常枚举
 *
 * @Author Gavin
 * @Date 2021/2/2 3:59 下午
 */
public enum CommonResultCodeEnum implements IResultCodeEnum {

    /**
     * 通用异常枚举
     */
    NONE(0,""),
    OK(200, "OK"),
    MOVED_PERMANENTLY(300, "Moved Permanently"),
    BAD_REQUEST(400, "Bad request"),
    UNAUTHORIZED(401, "Unauthorized"),
    NOT_FOUND(404, "Not found"),
    FORBIDDEN(403, "Forbidden"),
    CONFLICT(409, "Conflict"),
    INTERNAL_SERVER_ERROR(500, "Internal server error"),
    SERVICE_UNAVAILABLE(503, "Service Unavailable"),

    SUCCESS(1000, "成功"),
    COMMON_EXCEPTION(1001, "普通异常"),
    OPERATION_FAIL(1002, "操作失败"),

    ;

    private int value;
    private String desc;

    CommonResultCodeEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public int value() {
        return this.value;
    }

    @Override
    public String desc() {
        return this.desc;
    }

    public static CommonResultCodeEnum forValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (CommonResultCodeEnum messageCode : CommonResultCodeEnum.values()) {
            if (messageCode.value == value) {
                return messageCode;
            }
        }
        return null;
    }
}
