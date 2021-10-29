package com.mall.emaolv.service.base.handler;

import com.mall.emaolv.common.util.ResultCodeEnum;
import lombok.Data;

@Data
public class EduException extends RuntimeException{
    private Integer code;

    public EduException(String message, Integer code) {
        super(message);
        this.code = code;
    }
    public EduException(ResultCodeEnum resultCodeEnum){
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }
}
