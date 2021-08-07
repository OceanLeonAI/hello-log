package com.leon;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * @PROJECT_NAME: hello-log
 * @CLASS_NAME: JCLDemo
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2021/8/5 17:03
 * @Version 1.0
 * @DESCRIPTION:
 **/
public class JCLTest {

    @Test
    public void testHelloJCL() throws Exception {
        // 创建日志对象
        Log log = LogFactory.getLog(JCLTest.class);
        log.info("hello jcl");
    }

    @Test
    public void testQuick() throws Exception {
        // 创建日志对象
        Log log = LogFactory.getLog(JCLTest.class);
        // 日志记录输出
        log.fatal("fatal");
        log.error("error");
        log.warn("warn");
        log.info("info");
        log.debug("debug");
    }
}
