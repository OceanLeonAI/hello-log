package com.leon;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class Log4j2Test {

    // 定义日志记录器对象
    public static final Logger LOGGER = LogManager.getLogger(Log4j2Test.class);

    // 快速入门
    @Test
    public void testQuick() throws Exception {
        for (int i = 0; i < 10000; i++) {
            // 日志消息输出
            LOGGER.fatal("fatal");
            LOGGER.error("error");
            LOGGER.warn("warn");
            LOGGER.info("inf");
            LOGGER.debug("debug");
            LOGGER.trace("trace");
        }
    }

    @Test
    public void testQuickSystemOut() throws Exception {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            // 日志消息输出
            System.out.println("fatal");
            System.out.println("error");
            System.out.println("warn");
            System.out.println("inf");
            System.out.println("debug");
            System.out.println("trace");
        }
        System.out.println("耗时 --- " + TimeUnit.MILLISECONDS.toMillis(System.currentTimeMillis() - begin));
    }
}
