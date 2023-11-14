package com.company.a.service;

import cn.hutool.core.util.IdUtil;
import com.company.a.dao.cms.CmsUserDao;
import com.company.a.entity.CmsUser;
import com.raf.framework.autoconfigure.common.result.RafResult;
import com.raf.framework.autoconfigure.util.BatchHandlerUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jerry
 * @date 2022/06/15
 */
@Slf4j
@Service
public class DbTestServiceImpl implements DbTestService {
    @Autowired
    private CmsUserDao cmsUserDao;

    @Override
    public RafResult<?> test() {
        CmsUser cmsUser=cmsUserDao.queryById(1);

        BatchHandlerUtil.execute(() -> {
            cmsUserDao.queryList("11111");
        }, (BatchHandlerUtil.BatchHandlerService<CmsUser>) models -> {
            models.forEach(c -> {
                log.info("aaa:{}", c.getAccount());
            });
        }, 1000);
        return RafResult.success(IdUtil.fastUUID()+"-"+cmsUser.getAccount());
    }
}
