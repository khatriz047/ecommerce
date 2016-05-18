package com.ecommerce.framework.logger;

/**
 * Created by Chandra Prakash Panday on 5/18/2016.
 */
public class LoggerBuilder {
    private static AbstractLogger logger;

    private static void buildLoggerChain() {

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        logger = errorLogger;
    }

    public static AbstractLogger getLogger() {
        buildLoggerChain();
        return logger;
    }

/*   public static void main(String[] args) {
      AbstractLogger loggerChain = getLogger();

      loggerChain.logMessage(AbstractLogger.INFO, 
         "This is an information.");

      loggerChain.logMessage(AbstractLogger.DEBUG, 
         "This is an debug level information.");

      loggerChain.logMessage(AbstractLogger.ERROR, 
         "This is an error information.");
   }*/
}