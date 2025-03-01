package com.thread.learn.threadings.basics;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import com.thread.learn.threadings.basic.Runner;

public class TestRunner {
    @Spy
    Runner runner;

    @BeforeEach
    void setUp() {
        runner = new Runner();
    }

    @Test
    void testRunner() {
        runner.start();
        assertTrue(true);
    }
}
