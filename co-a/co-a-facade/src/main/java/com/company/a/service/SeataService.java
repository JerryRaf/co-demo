package com.company.a.service;

import com.raf.framework.autoconfigure.common.result.RafResult;

public interface SeataService {
    RafResult<String> test(Integer type);
}