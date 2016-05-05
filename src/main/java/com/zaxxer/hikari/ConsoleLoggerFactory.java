package com.zaxxer.hikari;

/**
 * User: Daniil Sosonkin
 * Date: 5/5/2016 1:29 PM
 */
public class ConsoleLoggerFactory implements Loggable, Logger
    {
        @Override
        public Logger getLogger(Class clazz)
            {
                return this;
            }

        @Override
        public void warn(String msg)
            {
                System.out.println(msg);
            }

        @Override
        public void warn(String msg, Object... args)
            {
                System.out.println(msg);
            }

        @Override
        public void error(String msg, Object... args)
            {
                System.out.println(msg);
            }

        @Override
        public void debug(String msg, Object... args)
            {
                System.out.println(msg);
            }

        @Override
        public void info(String msg, Object... args)
            {
                System.out.println(msg);
            }

        @Override
        public boolean isDebugEnabled()
            {
                return true;
            }
    }
