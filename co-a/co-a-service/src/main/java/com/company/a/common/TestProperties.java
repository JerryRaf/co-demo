package com.company.a.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Jerry
 * @date 2019/01/01
 */
@Data
@Component
@ConfigurationProperties(prefix = "parent-test")
public class TestProperties {
    private String a;
}
