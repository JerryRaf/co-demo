package com.company.a.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jerry
 * @date 2021/11/25
 */
@Data
public class XxxReq implements Serializable {
    private static final long serialVersionUID = -1L;
    private String test1;
    private String test2;
    private String test3;
    private List<Aa> aa = new ArrayList<>();

    @Data
    public static class  Aa{
        private String test1;
        private String test2;
        private String test3;
    }
}
