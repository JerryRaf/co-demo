package com.company.a.rsa;

import com.company.a.service.DubboTestService;
import com.raf.framework.autoconfigure.common.result.RafResult;
import com.raf.framework.autoconfigure.jackson.Json;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Jerry
 * @date 2023/04/06
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class DubboServiceImplTest {

    @DubboReference
    DubboTestService dubboTestService;

    @Autowired
    Json json;


    @Test
    public void test2() {
        RafResult<?> result1 = dubboTestService.test(1);
        log.info(json.objToString(result1));

        RafResult<?> result2 = dubboTestService.test(2);
        log.info(json.objToString(result2));

        RafResult<?> result3 = dubboTestService.test(3);
        log.info(json.objToString(result3));

        RafResult<?> result4 = dubboTestService.test(4);
        log.info(json.objToString(result4));

        RafResult<?> result5 = dubboTestService.test(5);
        log.info(json.objToString(result5));
    }
}