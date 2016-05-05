package com.zaxxer.hikari;

/**
 * User: Daniil Sosonkin
 * Date: 5/5/2016 11:03 AM
 */
public class SLF4JLogger implements Logger
    {
        private org.slf4j.Logger logger;


        public SLF4JLogger(org.slf4j.Logger logger)
            {
                this.logger = logger;
            }

        @Override
        public void warn(String msg)
            {
                logger.warn(msg);
            }

        @Override
        public void warn(String msg, Object... args)
            {
                logger.warn(msg, args);
            }

        @Override
        public void error(String msg, Object... args)
            {
                logger.error(msg, args);
            }

        @Override
        public void debug(String msg, Object... args)
            {
                logger.debug(msg, args);
            }

        @Override
        public void info(String msg, Object... args)
            {
                logger.info(msg, args);
            }

        @Override
        public boolean isDebugEnabled()
            {
                return logger.isDebugEnabled();
            }
    }
