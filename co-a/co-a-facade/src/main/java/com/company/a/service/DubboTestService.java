package com.company.a.service;

import com.raf.framework.autoconfigure.common.result.RafResult;

/**
 * @author Jerry
 * @date 2022/06/15
 */
public interface DubboTestService {
    RafResult<?> test(Integer type);
}
