package com.company.common.util;

import cn.hutool.core.util.IdUtil;
import com.company.common.constant.ResponseEnum;
import com.raf.framework.autoconfigure.common.exception.BusinessException;
import com.raf.framework.autoconfigure.common.exception.SystemException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Jerry
 * @date 2023/08/24
 */
@Slf4j
public class TestUtil {

    public static void getException(Integer type) {
        switch (type) {
            case 1:
                log.info("BusinessException");
                throw new BusinessException(ResponseEnum.ERROR_CODE_11000);
            case 2:
                log.info("a/0 Exception");
                int a = 1;
                int b = 0;
                int c = a / b;
                break;
            case 3:
                log.info("runException");
                throw new RuntimeException(IdUtil.fastUUID());
            case 4:
                log.info("SystemException");
                throw new SystemException(IdUtil.fastUUID());
            default:
                break;
        }
    }
}
