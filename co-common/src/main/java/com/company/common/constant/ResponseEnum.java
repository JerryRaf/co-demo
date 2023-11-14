package com.company.common.constant;

import com.raf.framework.autoconfigure.common.result.IResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 公用返回code
 *
 * @author Jerry
 * @date 2018/10/29 15:50
 * 业务code返回枚举
 * 1.每个服务一个区间，一块业务可以设置一些间隔，预留一些值（为业务新增code预留顺序code）
 * 2.仅弹出前端友好错误提示,数量精简重用
 */
@Getter
@AllArgsConstructor
public enum ResponseEnum implements IResponseEnum {
    /**
     * service a code:11000-11999
     */
    ERROR_CODE_11000(11000, "xxx"),
    ;
    private final int code;
    private final String msg;
}