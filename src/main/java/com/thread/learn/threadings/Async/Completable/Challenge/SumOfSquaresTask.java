package com.thread.learn.threadings.Async.Completable.Challenge;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class SumOfSquaresTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        TimeUnit.SECONDS.sleep(2);
        return 100;
    }

}
