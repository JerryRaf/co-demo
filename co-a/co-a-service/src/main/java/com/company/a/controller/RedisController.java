package com.company.a.controller;

import com.company.a.service.RedisServiceImpl;
import com.raf.framework.autoconfigure.common.result.RafResult;
import com.raf.framework.autoconfigure.servlet.http.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * redis
 *
 * @author Jerry
 * @date 2019/01/01
 */
@Slf4j
@RequestMapping("/redis")
@RestController
@ResponseResult
public class RedisController {

    @Autowired
    private RedisServiceImpl redissonService;

    @GetMapping(value = "/test")
    public RafResult<?> test() {
        redissonService.test();
        return RafResult.success();
    }

    /**
     * test接口
     *
     * @return
     */
    @GetMapping(value = "/test2")
    public RafResult<?> test2(String lockKey, Integer sleepTime) {
        redissonService.testLock(lockKey, sleepTime);
        return RafResult.success("23232");
    }

}
