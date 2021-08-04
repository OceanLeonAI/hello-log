package com.leon;

import org.junit.Test;

import java.util.logging.*;

/**
 * @PROJECT_NAME: hello-log
 * @CLASS_NAME: JULTest
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/8/4 12:37
 * @Version 1.0
 * @DESCRIPTION:
 **/
public class JULTest {

    @Test
    public void testQuick() {
        // 1.创建日志记录器对象
        Logger logger = Logger.getLogger("com.leon.JULTest");

        // 2.日志输出
        logger.info("hello jul");
        logger.log(Level.INFO, "info msg");
        String name = "jack";
        Integer age = 18;
        logger.log(Level.INFO, "用户信息：{0},{1}", new Object[]{name, age});
    }

    @Test
    public void testLogLevel() throws Exception {
        // 1.获取日志对象
        Logger logger = Logger.getLogger("com.leon.JULTest");
        // 2.日志记录输出
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("cofnig");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

    @Test
    public void testLogConfig() throws Exception {
        // 1.创建日志记录器对象
        Logger logger = Logger.getLogger("com.leon.JULTest");
        // 一、自定义日志级别
        // a.关闭系统默认配置
        logger.setUseParentHandlers(false);
        // b.创建handler对象
        ConsoleHandler consoleHandler = new ConsoleHandler();
        // c.创建formatter对象
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        // d.进行关联
        consoleHandler.setFormatter(simpleFormatter);
        logger.addHandler(consoleHandler);
        // e.设置日志级别
        logger.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);
        // 二、输出到日志文件
        FileHandler fileHandler = new FileHandler("f:/jul.log");
        fileHandler.setFormatter(simpleFormatter);
        logger.addHandler(fileHandler);
        // 2.日志记录输出
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }
}
