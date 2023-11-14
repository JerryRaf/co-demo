package com.company.a.rsa;

import com.company.a.service.RedisServiceImpl;
import lombok.extern.slf4j.Slf4j;
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
public class RedisServiceImplTest {
    @Autowired
    RedisServiceImpl redisService;

    @Test
    public void test1() {
        redisService.test();
    }
}