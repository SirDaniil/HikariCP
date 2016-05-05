package com.zaxxer.hikari;

/**
 * User: Daniil Sosonkin
 * Date: 5/5/2016 10:59 AM
 */
public class LoggerFactory
    {
        public static Loggable impl = null;

        public static synchronized Logger getLogger(Class clazz)
            {
                if (impl == null)
                    impl = new SLF4JLoggerFactory();

                return impl.getLogger(clazz);
            }
    }
