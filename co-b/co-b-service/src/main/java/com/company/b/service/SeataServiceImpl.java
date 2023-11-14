package com.company.b.service;

import cn.hutool.core.util.IdUtil;
import com.company.b.dao.cms.CmsUserDao;
import com.company.b.entity.CmsUser;
import com.company.common.util.TestUtil;
import com.raf.framework.autoconfigure.common.result.RafResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Jerry
 * @date 2021/09/29
 */
@Slf4j
@DubboService
public class SeataServiceImpl implements SeataService {
    @Autowired
    private CmsUserDao cmsUserDao;

    @Override
//    @Transactional(rollbackFor = Exception.class)
    public RafResult<String> test(Integer type) {
//        log.info("服务B开始,XID:{}", RootContext.getXID());

        CmsUser cmsUser = new CmsUser();
        cmsUser.setAccount(type.toString());
        cmsUser.setEmail("2323@qq.com");
        cmsUser.setIdCard("2323");
        cmsUser.setPassword("23");
        cmsUser.setIdCardCipherId(11L);
        cmsUser.setIdCardCipherText("");
        cmsUser.setSex(1);
        cmsUser.setStatus(1);
        cmsUserDao.insert(cmsUser);

        TestUtil.getException(type);
//        log.info("服务B结束,XID:{}", RootContext.getXID());
        return RafResult.success(IdUtil.fastSimpleUUID());
    }
}
