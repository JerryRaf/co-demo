package com.company.a.controller;

import com.company.a.service.SeataService;
import com.raf.framework.autoconfigure.common.result.RafResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/seata")
public class SeataController {
    @DubboReference
    private SeataService seataService;

    @GetMapping("/test")
    public RafResult<?> test(Integer type) {
        seataService.test(type);
        return RafResult.success();
    }
}
