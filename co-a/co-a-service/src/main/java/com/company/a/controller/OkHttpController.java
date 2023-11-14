package com.company.a.controller;

import com.company.a.service.OkHttpServiceImpl;
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
@RequestMapping("/okhttp")
public class OkHttpController {

    @Autowired
    private OkHttpServiceImpl okHttpService;

    @GetMapping("/test")
    public RafResult<?> get() {
        okHttpService.get();
        return RafResult.success();
    }
}
