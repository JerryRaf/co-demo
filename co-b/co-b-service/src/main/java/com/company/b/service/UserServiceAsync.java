package com.company.b.service;

import com.company.common.util.TestUtil;
import com.raf.framework.autoconfigure.spring.async.ThreadPoolConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @author Jerry
 * @date 2020/07/27
 */
@Slf4j
@Service
public class UserServiceAsync {

    /**
     * 带参数的异步调用 异步方法可以传入参数
     * 对于返回值是void，异常会被AsyncUncaughtExceptionHandler处理掉
     *
     * @param type
     */
    @Async(ThreadPoolConfig.ASYNC_EXECUTOR_NAME)
    public void asyncInvokeWithException(Integer type) {
        TestUtil.getException(type);
    }

    /**
     * 异常调用返回Future
     * 对于返回值是Future，不会被AsyncUncaughtExceptionHandler处理，
     * 需要我们在方法中捕获异常并处理
     * 或者在调用方在调用Futrue.get时捕获异常进行处理
     *
     * @param type
     * @return
     */
    @Async(ThreadPoolConfig.ASYNC_EXECUTOR_NAME)
    public Future<String> asyncInvokeReturnFuture(Integer type) {
        Future<String> future;
        try {
            TestUtil.getException(type);
            future = new AsyncResult<String>("success");
        } catch (IllegalArgumentException e) {
            future = new AsyncResult<String>("error-IllegalArgumentException");
        } catch (Exception e) {
            future = new AsyncResult<String>("error-IllegalArgumentException");
        }
        return future;
    }
}
