package com.company.b.service;

import com.raf.framework.autoconfigure.common.result.RafResult;

public interface SeataService {
    RafResult<String> test(Integer type);
}