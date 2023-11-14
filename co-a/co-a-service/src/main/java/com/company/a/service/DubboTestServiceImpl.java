package com.company.a.service;

import com.company.b.dto.CmsUserReq;
import com.company.b.service.UserService;
import com.raf.framework.autoconfigure.common.result.RafResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author Jerry
 * @date 2022/06/15
 */
@Slf4j
@DubboService
public class DubboTestServiceImpl implements DubboTestService {
    @DubboReference
    private UserService userService;

    @Override
    public RafResult<?> test(Integer type) {
        CmsUserReq cmsUserReq = new CmsUserReq();
        cmsUserReq.setType(type);
        if (type > 0) {
            cmsUserReq.setEmail("2323@qq.com");
        }
        cmsUserReq.setName("2323");
        cmsUserReq.setSex(1);
        cmsUserReq.setPassword("23232@##$#$a23232");
        return userService.test(cmsUserReq);
    }

}
