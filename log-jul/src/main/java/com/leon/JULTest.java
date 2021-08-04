package com.leon;

import org.junit.Test;

import java.io.InputStream;
import java.util.logging.*;

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
        FileHandler fileHandler = new FileHandler("E:\\jul.log");
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

    @Test
    public void testLogParent() throws Exception {
        // 日志记录器对象父子关系
        Logger logger1 = Logger.getLogger("com.leon.JULTest");
        Logger logger2 = Logger.getLogger("com.leon");
        System.out.println(logger1.getParent() == logger2);
        // 所有日志记录器对象的顶级父元素 class为java.util.logging.LogManager$RootLogger name为 ""
        System.out.println("logger2 parent:" + logger2.getParent() + "，name：" +
                logger2.getParent().getName());
        // 一、自定义日志级别
        // a.关闭系统默认配置
        logger2.setUseParentHandlers(false);
        // b.创建handler对象
        ConsoleHandler consoleHandler = new ConsoleHandler();
        // c.创建formatter对象
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        // d.进行关联
        consoleHandler.setFormatter(simpleFormatter);
        logger2.addHandler(consoleHandler);
        // e.设置日志级别
        logger2.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);
        // 测试日志记录器对象父子关系
        logger1.severe("severe");
        logger1.warning("warning");
        logger1.info("info");
        logger1.config("config");
        logger1.fine("fine");
        logger1.finer("finer");
        logger1.finest("finest");
    }

    @Test
    public void testProperties() throws Exception {
        // 读取自定义配置文件
        InputStream in =
                JULTest.class.getClassLoader().getResourceAsStream("logging.properties"); // FIXME: 配置文件未读取到
        // 获取日志管理器对象
        LogManager logManager = LogManager.getLogManager();
        // 通过日志管理器加载配置文件
        logManager.readConfiguration(in);
        Logger logger = Logger.getLogger("com.leon.JULTest");
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

}
