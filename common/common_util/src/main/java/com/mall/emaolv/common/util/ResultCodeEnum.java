package com.mall.emaolv.common.util;

import lombok.Getter;
import lombok.ToString;


/**
 * @author ：Xiao Hei
 * @description：ResultCodeEnum
 * @date ：Created in 2021/10/23 15:41
 */
@Getter
@ToString
public enum ResultCodeEnum {
    SUCCESS(true, 20000, "成功"),
    UNKNOWN_REASON(false, 20001, "未知错误"),
    BAD_SQL_GRAMMAR(false, 21001, "sql语法错误"),
    JSON_PARSE_ERROR(false, 21002, "json解析异常");

    // 定义三个成员变量
    private Boolean success;
    private Integer code;
    private String message;

    ResultCodeEnum(Boolean success, Integer code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
