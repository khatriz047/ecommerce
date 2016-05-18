package com.ecommerce.framework.logger;

/**
 * Created by Chandra Prakash Panday on 5/18/2016.
 */
public class ConsoleLogger extends AbstractLogger {

   public ConsoleLogger(int level){
      this.level = level;
   }

   @Override
   protected void write(String message) {		
      System.out.println("Standard Console::Logger: " + message);
   }
}