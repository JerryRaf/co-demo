package com.company.a.rsa;

import cn.hutool.core.date.StopWatch;
import cn.hutool.core.lang.UUID;
import com.company.a.dto.XxxReq;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.raf.framework.autoconfigure.jackson.Json;
import com.raf.framework.autoconfigure.redis.RedisSingleton;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author Jerry
 * @date 2023/04/06
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ConcurrentTest {

    @Autowired
    RedisSingleton redisSingleton;

    @Autowired
    Json json;

    @Autowired
    private ObjectMapper objectMapper;

    private final Map<String, List<String>> serviceIdsMap = new HashMap<>();

    @Test
    public void test1() throws InterruptedException {
        StopWatch stopWatch = new StopWatch("test111");
        stopWatch.start("xxx0");
        Thread.sleep(100);
        stopWatch.stop();

        stopWatch.start("xxx1");
        Thread.sleep(290);
        stopWatch.stop();

        stopWatch.start("xxx2");
        Thread.sleep(120);
        stopWatch.stop();

        log.info("aaa:{}",stopWatch.prettyPrint(TimeUnit.MILLISECONDS));

//        ForkJoinPool forkJoinPool = new ForkJoinPool(100);
//        forkJoinPool.execute(() -> IntStream.rangeClosed(1, 100).parallel().forEach(c -> {
//            aaa();
//        }));
//
//        forkJoinPool.awaitTermination(5000, TimeUnit.MICROSECONDS);
//
//        stopWatch.stop();
//        log.info("time：" + stopWatch.getTotalTimeMillis() + " ms");
    }


    @Test
    public void test() throws InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool(100);
        forkJoinPool.execute(() -> IntStream.rangeClosed(1, 100).parallel().forEach(c -> {
//            JSON.
        }));

        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);


        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        aaa();

        stopWatch.stop();
        log.info("time：" + stopWatch.getTotalTimeMillis() + " ms");


    }

    private void aaa() {
        XxxReq.Aa xxxReq = new XxxReq.Aa();
        xxxReq.setTest1("test1");
        xxxReq.setTest2("test2");
        xxxReq.setTest3("test3");
        List<XxxReq.Aa> bb = new ArrayList<>();
        bb.add(xxxReq);
        bb.add(xxxReq);
        bb.add(xxxReq);


        XxxReq xxxReq1 = new XxxReq();
        xxxReq1.setTest1(UUID.fastUUID().toString());
        xxxReq1.setAa(bb);

        IntStream.rangeClosed(1, 2).parallel().forEach(c -> {
//            String b = json.objToString(xxxReq1);
//            log.info(b);
            try {
                String b = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(xxxReq1);
                log.info(b);
            } catch (JsonProcessingException e) {
            }
        });
    }

}