package com.mayu.guava.concurrency;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池测试
 *
 * Author 卡卡
 * Created by jing on 2017/5/18.
 */
public class ExecutorServiceTest {
    @Test
    public void test() throws Exception{
        //max thread num : 20
        ExecutorService pool = Executors.newFixedThreadPool(20);
        ListeningExecutorService service = MoreExecutors.listeningDecorator(pool);
        List<Callable<Map<String, Object>>> tasks;

        List<ListenableFuture<String>> futures = Lists.newArrayList();
        /*List<String> stringList = Lists.newArrayList();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");*/
        for (int i = 0; i < 100; i++) {
            ListenableFuture queryApp = service.submit(new Callable() {
                @Override
                public String call() throws Exception {
                    return "test...";
                }
            });
            futures.add(queryApp);
        }
        final ListenableFuture<List<String>> resultFuture = Futures.successfulAsList(futures);
        try {
            System.out.println(resultFuture.get());
        } catch (Exception e) {
            e.printStackTrace();
            pool.shutdown();
        }
        pool.shutdown(); //重点就是这行
        Thread.sleep(5000);
    }
}
