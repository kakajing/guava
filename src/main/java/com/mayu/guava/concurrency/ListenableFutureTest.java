package com.mayu.guava.concurrency;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Author 卡卡
 * Created by jing on 2017/5/17.
 */
public class ListenableFutureTest {

    @Test
    public void test() throws Exception{
        //init ListeningExecutorService
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());
        //使用submit方法初始化ListenableFuture
        List<ListenableFuture<?>> listenableFutures = Lists.newArrayList();

        listenableFutures.add(executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("exec 1..");

                return 1;
            }
        }));

        listenableFutures.add(executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("exec 2..");
                return 2;
            }
        }));

        ListenableFuture<List<Object>> results = Futures.allAsList(listenableFutures);
        String result = null;
        for (Object obj : results.get()) {
            if (obj != null) {
                System.out.println(obj.toString());
                result = obj.toString();
            }
        }
        System.out.println(result);
    }
}
