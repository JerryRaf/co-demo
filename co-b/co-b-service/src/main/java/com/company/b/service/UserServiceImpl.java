package com.company.b.service;

import com.alibaba.nacos.common.utils.UuidUtils;
import com.company.b.dao.cms.CmsUserDao;
import com.company.b.dto.CmsUserReq;
import com.company.b.dto.CmsUserRes;
import com.company.b.entity.CmsUser;
import com.company.common.util.TestUtil;
import com.raf.framework.autoconfigure.common.result.RafResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;


/**
 * 示例：dubbo
 * 返回两种封装类型结果测试
 * 分布式追踪测试,含dubbo传输+异步线程传输
 * dubbo调用测试
 * dubbo全局异常测试
 *
 * @author Jerry
 * @date 2019/01/01 12:00
 */
@Slf4j
@DubboService
public class UserServiceImpl implements UserService {

    @Autowired
    private CmsUserDao userDao;

    @Override
    public RafResult<CmsUserRes> test(CmsUserReq request) {
        String uuid = UuidUtils.generateUuid();
        CmsUserRes sayResponse = new CmsUserRes();
        CmsUser cmsUser=userDao.queryById(1);
        String email=cmsUser.getEmail();
        sayResponse.setContent(uuid.concat("--aa-").concat(email));
        TestUtil.getException(request.getType());

        cmsUser.setEmail(uuid);
        userDao.update(cmsUser);
        return RafResult.success(sayResponse);
    }
}