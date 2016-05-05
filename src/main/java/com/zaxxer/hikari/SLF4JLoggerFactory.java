package com.zaxxer.hikari;

/**
 * User: Daniil Sosonkin
 * Date: 5/5/2016 11:02 AM
 */
public class SLF4JLoggerFactory implements Loggable
    {
        public com.zaxxer.hikari.Logger getLogger(Class clazz)
            {
                return new SLF4JLogger(org.slf4j.LoggerFactory.getLogger(clazz));
            }
    }
