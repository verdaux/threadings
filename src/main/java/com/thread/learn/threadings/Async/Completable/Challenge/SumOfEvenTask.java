package com.thread.learn.threadings.Async.Completable.Challenge;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class SumOfEvenTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        TimeUnit.SECONDS.sleep(4);
        return 100;
    }

}
