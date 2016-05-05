package com.zaxxer.hikari;

import java.util.*;

/**
 * User: Daniil Sosonkin
 * Date: 5/5/2016 1:33 PM
 */
public class Log4jLogger implements Logger
    {
        private enum Level {DEBUG, ERROR, INFO, WARN}
        private org.apache.log4j.Logger logger;

        public Log4jLogger(org.apache.log4j.Logger logger)
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
                log(Level.WARN, msg, args);
            }

        @Override
        public void error(String msg, Object... args)
            {
                log(Level.ERROR, msg, args);
            }

        @Override
        public void debug(String msg, Object... args)
            {
                log(Level.DEBUG, msg, args);
            }

        @Override
        public void info(String msg, Object... args)
            {
                log(Level.INFO, msg, args);
            }

        @Override
        public boolean isDebugEnabled()
            {
                return logger.isDebugEnabled();
            }

        private void log(Level level, String s, Object... objects)
            {
                if (objects == null)
                    {
                        switch (level)
                            {
                                case INFO:
                                    logger.info(s);
                                    break;

                                case DEBUG:
                                    logger.debug(s);
                                    break;

                                case ERROR:
                                    logger.error(s);
                                    break;

                                case WARN:
                                    logger.warn(s);
                                    break;
                            }
                    }
                else
                    {
                        List list = Arrays.asList(objects);
                        List<String> args = new ArrayList<>();
                        Throwable e = null;

                        for (Object o : list)
                            if (o instanceof Throwable)
                                {
                                    e = (Throwable)o;
                                    break;
                                }
                            else
                                args.add(o == null ? "null" : o.toString());

                        String msg = String.format(s.replace("{}", "%s"), args.toArray(new Object[args.size()]));

                        if (e == null)
                            log(level, msg);
                        else
                            {
                                switch (level)
                                    {
                                        case INFO:
                                            logger.info(msg, e);
                                            break;

                                        case DEBUG:
                                            logger.debug(msg, e);
                                            break;

                                        case ERROR:
                                            logger.error(msg, e);
                                            break;

                                        case WARN:
                                            logger.warn(msg, e);
                                            break;
                                    }
                            }
                    }
            }
    }
