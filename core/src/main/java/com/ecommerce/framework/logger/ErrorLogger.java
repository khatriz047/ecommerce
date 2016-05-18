package com.ecommerce.framework.logger;

/**
 * Created by Chandra Prakash Panday on 5/18/2016.
 */
public class ErrorLogger extends AbstractLogger {

   public ErrorLogger(int level){
      this.level = level;
   }

   @Override
   protected void write(String message) {		
      System.out.println("Error Console::Logger: " + message);
   }
}