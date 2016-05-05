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
                    {
                        if (isLog4jAvailable())
                            impl = new Log4jLoggerFactory();
                        if (isSlf4jAvailable())
                            impl = new SLF4JLoggerFactory();
                        else
                            impl = new ConsoleLoggerFactory();
                    }

                return impl.getLogger(clazz);
            }

        private static boolean isSlf4jAvailable()
            {
                try
                    {
                        Class.forName("org.slf4j.LoggerFactory");
                    }
                catch (Throwable e)
                    {
                        return false;
                    }

                return true;
            }

        private static boolean isLog4jAvailable()
            {
                try
                    {
                        Class.forName("org.apache.log4j.Logger");
                    }
                catch (Throwable e)
                    {
                        return false;
                    }

                return true;
            }
    }
