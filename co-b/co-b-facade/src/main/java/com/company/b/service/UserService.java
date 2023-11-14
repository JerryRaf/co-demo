package com.company.b.service;

import com.company.b.dto.CmsUserReq;
import com.company.b.dto.CmsUserRes;
import com.raf.framework.autoconfigure.common.result.RafResult;

import javax.validation.Valid;

public interface UserService {
    RafResult<CmsUserRes> test(@Valid CmsUserReq request);
}