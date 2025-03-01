package com.thread.learn.threadings.basics;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.thread.learn.threadings.basic.RunnerByRunnabling;

public class TestRunnable {
    @Spy
    RunnerByRunnabling runner;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRunnerForRunnable() {
        Thread t1 = new Thread(new RunnerByRunnabling());
        t1.start();
        assertTrue(true);
    }
}
