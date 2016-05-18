package com.ecommerce.framework.logger;

/**
 * Created by Chandra Prakash Panday on 5/18/2016.
 */
public class FileLogger extends AbstractLogger {

   public FileLogger(int level){
      this.level = level;
   }

   @Override
   protected void write(String message) {		
      System.out.println("File::Logger: " + message);
   }
}