package com.company.a.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Jerry
 * @date 2021/11/25
 */
@Getter
@AllArgsConstructor
public enum XxxEnum {
    /**
     * xxx
     */
    Xxx(1, "xxx"),
    Xxx_xxx(2, "Xxx_xxx"),
    ;

    private final int code;
    private final String msg;

}
