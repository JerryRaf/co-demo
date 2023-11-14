package com.company.a.service;

import cn.hutool.core.util.IdUtil;
import com.company.a.dao.cms.CmsUserDao;
import com.company.a.entity.CmsUser;
import com.company.common.util.TestUtil;
import com.raf.framework.autoconfigure.common.result.RafResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Jerry
 * @date 2021/09/29
 */
@Slf4j
@DubboService
public class SeataServiceImpl implements SeataService {
    @DubboReference
    private com.company.b.service.SeataService seataService;

    @Autowired
    private CmsUserDao cmsUserDao;

    /**
     * 1服务调用成功，本地成功
     * 2服务调用成功，本地失败  回滚
     * 3服务调用失败，结束
     */
    @Override
    public RafResult<String> test(Integer type) {
        aaa(type);
        return RafResult.success(IdUtil.fastUUID());
    }

    //    @GlobalTransactional(rollbackFor = Exception.class)
    public void aaa(Integer type) {
//        log.info("服务A开始，开始全局事务,XID:{}", RootContext.getXID());
        RafResult<String> result = seataService.test(type);
//        log.info("服务B调用结束,XID:{}", RootContext.getXID());

        CmsUser cmsUser = new CmsUser();
        cmsUser.setAccount(IdUtil.fastUUID());
        cmsUserDao.insert(cmsUser);

        TestUtil.getException(type);

//        log.info("服务A结束,XID:{}", RootContext.getXID());
    }
}
