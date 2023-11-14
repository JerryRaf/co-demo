package com.company.a.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.Maps;
import com.raf.framework.autoconfigure.common.result.RafResult;
import com.raf.framework.autoconfigure.mybatis.PageResponse;
import com.raf.framework.autoconfigure.okhttp.OkHttpClientBuilder;
import com.raf.framework.autoconfigure.okhttp.RafOkHttpClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Jerry
 * @date 2021/07/21
 */
@Slf4j
@Service
public class OkHttpServiceImpl {

    @Autowired
    private RafOkHttpClient rafOkHttpClient;

    public void get() {
        String url = "http://127.0.0.1:8081/okhttp/getService";

        try {
            Map<String, String> headers = Maps.newHashMapWithExpectedSize(1);
            headers.put("header1", "111");

            Map<String, String> params = Maps.newHashMapWithExpectedSize(2);
            params.put("pageNum", "1");
            params.put("pageSize", "2");
            params.put("type", "0");

            OkHttpClientBuilder okHttpClientBuilder = OkHttpClientBuilder.builder()
                    .url(url)
                    .headers(headers)
                    .params(params)
                    .typeReference(new TypeReference<RafResult<Object>>() {
                    }).build();

            RafResult<Object> rafResult = rafOkHttpClient.get(okHttpClientBuilder);
            if (rafResult.isSuccess()) {
                Object obj = rafResult.getData();
            } else {
                log.error("get fail:");
            }
        } catch (Exception ex) {
            log.error("get ex:", ex);
        }
    }

    public Boolean post() {
        String url = "http://127.0.0.1:8090/users";
        Map<String, String> params = Maps.newHashMapWithExpectedSize(2);
        params.put("a", "1");
        params.put("b", "2");

        Map<String, String> headers = Maps.newHashMapWithExpectedSize(1);
        headers.put("customHeader", "header111");

        OkHttpClientBuilder okHttpClientBuilder = OkHttpClientBuilder.builder()
                .headers(headers)
                .params(params)
                .url(url)
                .typeReference(new TypeReference<RafResult<PageResponse<Object>>>() {
                }).build();

        try {
            RafResult<PageResponse<Object>> rafResult = rafOkHttpClient.post(okHttpClientBuilder);
            return rafResult.isSuccess();
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            return false;
        }
    }

    public void put() {
        String url = "https://xxxxx";

        Map<String, String> headers = Maps.newHashMapWithExpectedSize(1);
        headers.put("aaa", "PEF1dGhlbnRpY2F0aW9uPjxJZD4zMmE1ZmQ3Ny01ZjNhLTQyYjQtYjI2NS0wOTliYzRkZjBmYWM8L0lkPjxVc2VyTmFtZT5ZMU9VaFU5U2RJeGlMWmRVNk1EQUpSVE5VRmxSSHIveDZ0SitTNGZ2UU5UeFZ5M21nNGc5bVJ2SURKSS9ySmRiOWdQbUJ1Y0JIaHo0enA4dVN4NThrc25Jb2Q5R3k5UDlLMHVHOFV4bHJ0VGdpR1BNQ1ZoMFJUcFh4M2dYNGRVRUdGZXhaa2ZkTWhBT05saDBMQXBBQTlTNmZNT2N1VXZ2S3V2S2tnenhzYkk9PC9Vc2VyTmFtZT48UGFzc3dvcmQ+ekNTRTBlOE9FTlpMVmM1ODBIYjlRV0twaHFCTDVBYVhSUWFpM3NrYkFJVHAyY3lRWTJ0dWxBZzFPMCs2ZG5hUDM3S3J0d1Z1TkZYUlpFTlBMQkZ5UTlrSGVUcVJtNnFhVkVEQmNEVjV1Q05EeFFLVHlacVJ4NkVjdkY0Ni9ZQlp5d21QOW05L1IvcmhKUEFOemZMZmFlZmYzRHVDSktVa1NOa2lZT0RpaWEwPTwvUGFzc3dvcmQ+PEJyYW5jaElkPjBBQmN5c01xSVJkUlRneVNBQktFc2dRbGdCVVJxOXFrUGV1b0h6Q1lTc0p0SkFaMmhWQ2NOWndkQVRDNVM3c1ptYkwrRTVmN3ZQQnUxQUhESTlHT01odHhpL0pYbEZxVi9iYkZHNXVzUS9yWStoUHNBV3hTbHBBS0dPOXhSajVoNTFvRGprT0lRSWQxRDRVU2lpQmNWVmYvTkk3Njkzbm9TcDdmSEg4MDFUST08L0JyYW5jaElkPjwvQXV0aGVudGljYXRpb24+");
        headers.put("Content-Type", "application/json");

        Map<String, String> params = Maps.newHashMapWithExpectedSize(2);
        params.put("bbb", "111");

        OkHttpClientBuilder okHttpClientBuilder = OkHttpClientBuilder.builder()
                .headers(headers)
                .params(params)
                .url(url)
                .typeReference(null).build();

        try {
            Object rafResult = rafOkHttpClient.put(okHttpClientBuilder);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
    }

}
