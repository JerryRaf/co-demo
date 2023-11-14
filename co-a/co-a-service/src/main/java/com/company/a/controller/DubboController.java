package com.company.a.controller;

import com.company.a.service.DubboTestService;
import com.raf.framework.autoconfigure.common.result.RafResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/dubbo")
public class DubboController {

    @Autowired
    private DubboTestService dubboTestService;

    @GetMapping("/test")
    public RafResult<?> test(Integer type) {
        return dubboTestService.test(type);
    }
}
