package com.zaxxer.hikari;

/**
 * User: Daniil Sosonkin
 * Date: 5/5/2016 10:58 AM
 */
public interface Logger
    {
        void warn(String msg);

        void warn(String msg, Object... args);

        void error(String msg, Object... args);

        void debug(String msg, Object... args);

        void info(String msg, Object... args);

        boolean isDebugEnabled();
    }
