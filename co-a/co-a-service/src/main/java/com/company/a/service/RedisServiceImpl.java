package com.company.a.service;

import com.company.a.entity.CmsUser;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.raf.framework.autoconfigure.common.exception.BusinessException;
import com.raf.framework.autoconfigure.common.result.RafResponseEnum;
import com.raf.framework.autoconfigure.jackson.Json;
import com.raf.framework.autoconfigure.redis.RedisSingleton;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Jerry
 * @date 2021/07/21
 */
@Slf4j
@Service
public class RedisServiceImpl {
    @Autowired
    private RedisSingleton redisSingleton;

    @Autowired(required = false)
    private RedissonClient redissonClient;

    @Autowired
    private Json json;

    public void test() {
        redisSingleton.set("str1", "forever");
        redisSingleton.set("str2", "10 s",10);
        log.info(redisSingleton.get("str1"));

        List<String> list = Lists.newArrayList();
        list.add("a");
        list.add("b");
        redisSingleton.set("list1", json.objToString(list));
        redisSingleton.set("list2", json.objToString(list), 10);
        log.info(redisSingleton.get("list1"));
        log.info(redisSingleton.get("list2"));


        RMap<String, String> c = redissonClient.getMap("map-test");
        Map<String, String> test = Maps.newHashMap();
        test.put("1", "2323232");
        test.put("aaasf", "sdfsdfsfsf");

        RMap<String, String> a = redissonClient.getMap("map-test");
        a.putAll(test, 1000);

        //json
        CmsUser cmsUser=new CmsUser();
        cmsUser.setAccount("aaa");

        String str = json.objToString(cmsUser);
        log.info(str);

        CmsUser cmsUser2 = json.strToObj(str, CmsUser.class);
    }

    public void testLock(String lockKey, Integer sleepTime) {
        try {
            log.info("start" + Thread.currentThread().getName());

            if (!tryLock(lockKey, 1000L, 8000L)) {
                log.error("未获得锁抛异常" + Thread.currentThread().getName());
                throw new BusinessException(RafResponseEnum.SERVER_ERROR);
            }

            log.info("获得锁" + Thread.currentThread().getName());
            //do your business
            log.info("end");
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            log.info("finally start" + Thread.currentThread().getName());
            unlock(lockKey);
        }
    }

    /**
     * lock.tryLock() 默认wait:0 leaseTime:30s leaseTime：-1会启动一个看门狗
     * lock.tryLock(3, 10, TimeUnit.SECONDS) 尝试加锁，最多等待3秒，上锁以后10秒自动解锁
     * lock.tryLock(10, TimeUnit.SECONDS) 支持过期解锁功能,10秒钟以后自动解锁,
     * 无需调用unlock方法手动解锁
     */
    public boolean tryLock(String lockKey, long waitTime, long leaseTime) {
        boolean b;
        try {
            RLock lock = redissonClient.getLock(lockKey);
            b = lock.tryLock(waitTime, leaseTime, TimeUnit.MILLISECONDS);
        } catch (Throwable e) {
            //此处的异常抛出，会被上层catch接住，然后上层final里面会释放锁
            String msg = String.format("LOCK FAILED: key=%s||tryLockTime=%s||lockExpiredTime=%s", lockKey, waitTime, leaseTime);
            throw new IllegalStateException(msg, e);
        }
        return b;
    }

    /**
     * 解锁方法
     *
     * @param lockKey
     */
    public void unlock(String lockKey) {
        try {
            RLock lock = redissonClient.getLock(lockKey);
            log.info("unlock start " + lock.isLocked() + "-" + lock.isHeldByCurrentThread() + "-" + Thread.currentThread().getName());
            //如果其他线程还在处理就不释放锁，当前线程是否持有此锁定
            if (lock.isHeldByCurrentThread()) {
                log.info("unlock success" + Thread.currentThread().getName());
                lock.unlock();
            }
        } catch (Throwable e) {
            String msg = String.format("UNLOCK FAILED: key=%s", lockKey);
            throw new IllegalStateException(msg, e);
        }
    }

//    public void testConcurrentLock() {
//        String key = "srm-sync-test-lock6";
//        LockThread lockThreadA = new LockThread(key, 5);
//        LockThread lockThreadB = new LockThread(key, 1);
//
//        try {
//            //场景1：线程A一直在执行，线程B不会释放线程A的锁
////            new Thread(lockThreadA, "Thread-A").start();
////            TimeUnit.SECONDS.sleep(1);//秒
////            new Thread(lockThreadB, "Thread-B").start();
//
//            //场景2：
//            LockThread lockThreadC= new LockThread(key, 10);
//            new Thread(lockThreadC, "Thread-C").start();
//
//            TimeUnit.SECONDS.sleep(20);
//        } catch (InterruptedException e) {
//            log.info(e.getMessage());
//        }
//    }
//
//    class LockThread implements Runnable {
//        private String lockKey;
//        private int sleepTime;
//
//        public LockThread(String lockKey, int sleepTime) {
//            this.lockKey = lockKey;
//            this.sleepTime = sleepTime;
//        }
//
//        @Override
//        public void run() {
//            lockDemo(lockKey, sleepTime);
//        }
//    }

}
