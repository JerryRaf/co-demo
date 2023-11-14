package com.company.a.controller;

import com.company.a.service.DbTestService;
import com.raf.framework.autoconfigure.common.result.RafResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jerry
 */
@Slf4j
@RestController
@RequestMapping("/db")
public class DbController {

    @Autowired
    private DbTestService dbTestService;

    @GetMapping("/test")
    public RafResult<?> test() {
        return dbTestService.test();
    }
}
