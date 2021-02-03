package com.hoe.sentient.common.result;

import lombok.Data;

/**
 * 返回结果统一格式
 *
 * @Author Gavin
 * @Date 2021/2/2 3:55 下午
 */
@Data
public class Result<T> {
//    @ApiModelProperty(value = "返回结果编码",name = "code")
    private int code;
//    @ApiModelProperty(value = "返回结果Result",name = "Result")
    private String message;
//    @ApiModelProperty(value = "返回结果数据",name = "data")
    private T data;

    /**
     * 创建已知类型的失败消息
     *
     * @param codeEnum 错误信息
     * @return 消息
     */
    public static <T> Result<T> error(IResultCodeEnum codeEnum) {
        Result<T> msg = new Result<>();
        msg.setCode(codeEnum.value());
        msg.setMessage(codeEnum.resDesc());
        return msg;
    }

    /**
     * 创建指定错误码的失败消息
     *
     * @param codeEnum 错误码
     * @param Result  错误信息
     * @return 消息
     */
    public static <T> Result<T> error(IResultCodeEnum codeEnum, String Result) {
        Result<T> msg = new Result<>();
        msg.setCode(codeEnum.value());
        msg.setMessage(Result);
        return msg;
    }

    /**
     * 创建已知类型的失败消息
     *
     * @param codeEnum 错误码
     * @param Result  错误信息
     * @param data 结果数据
     * @return 消息
     */
    public static <T> Result<T> error(IResultCodeEnum codeEnum, String Result, T data) {
        Result<T> msg = new Result<>();
        msg.setCode(codeEnum.value());
        msg.setMessage(Result);
        msg.setData(data);
        return msg;
    }

    /**
     * 创建成功消息
     *
     * @param data 结果数据
     * @return 消息
     */

    public static <T> Result<T> success(T data) {
        Result<T> msg = new Result<>();
        msg.setCode(CommonResultCodeEnum.SUCCESS.value());
        msg.setData(data);
        return msg;
    }

    /**
     * 创建成功消息
     *
     * @param data 结果数据
     * @return 消息
     */

    public static <T> Result<T> success(IResultCodeEnum codeEnum, T data) {
        Result<T> msg = new Result<>();
        msg.setCode(codeEnum.value());
        msg.setData(data);
        return msg;
    }

    /**
     * 创建成功消息 为了兼容老版本
     *
     * @return 消息
     */

    public static <T> Result<T> success(IResultCodeEnum codeEnum) {
        Result<T> msg = new Result<>();
        msg.setCode(codeEnum.value());
        return msg;
    }


    /**
     * 创建成功消息
     *
     * @return 消息
     */
    public static <T> Result<T> success() {
        return success(CommonResultCodeEnum.SUCCESS);
    }

    /**
     * 创建成功消息
     *
     * @return 消息
     */
    public static Result<String> complete(boolean operateResult) {
        if(operateResult) {
            return success(CommonResultCodeEnum.SUCCESS);
        }
        else {
            return error(CommonResultCodeEnum.OPERATION_FAIL);
        }
    }

    public boolean callSuccess() {
        if (code == CommonResultCodeEnum.SUCCESS.value()) {
            return true;
        }
        return false;
    }

}
