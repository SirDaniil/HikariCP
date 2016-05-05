package com.zaxxer.hikari;

/**
 * User: Daniil Sosonkin
 * Date: 5/5/2016 10:59 AM
 */
public class LoggerFactory
    {
        public static Loggable impl = new SLF4JLoggerFactory();

        public static Logger getLogger(Class clazz)
            {
                return impl.getLogger(clazz);
            }
    }
