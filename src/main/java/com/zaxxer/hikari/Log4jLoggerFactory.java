package com.zaxxer.hikari;

/**
 * User: Daniil Sosonkin
 * Date: 5/5/2016 1:33 PM
 */
public class Log4jLoggerFactory implements Loggable
    {
        @Override
        public Logger getLogger(Class clazz)
            {
                return new Log4jLogger(org.apache.log4j.Logger.getLogger(clazz));
            }
    }
