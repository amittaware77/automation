package com.cognizant.test.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Level;
import org.testng.Reporter;

public class LoggerUtil {
   static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger("devpinoyLogger"); 
	 
   public static void logMessage(String message) {
		Reporter.log(message, false);
		logConsoleMessage(message);
        log.info(message);
   }
	
    //Logs a message to the console only	
	public static void logConsoleMessage(String message) {
       System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(new Date()) + " " + message);
   }
	
    //Logs a message in Log4J and Console file	
	public static void logErrorMessage(String message) {
		 System.out.println("Error: " + message);
		 log.error(message);
   }
	
    //Disables log4j console output. Helpful if you don't want a lot of console clutter.		
	public static void disableLog4JConsoleOutput() {
		LoggerUtil.logConsoleMessage("Disabling log4j console output.");
		org.apache.log4j.Logger.getLogger("org.BIU.utils.logging.ExperimentLogger").setLevel(Level.OFF);
		org.apache.log4j.Logger.getRootLogger().setLevel(Level.OFF);
	}
	
    //Enables log4j console output.
	public static void enableLog4JConsoleOutput() {
		LoggerUtil.logConsoleMessage("Enabling log4j console output.");
		org.apache.log4j.Logger.getLogger("org.BIU.utils.logging.ExperimentLogger").setLevel(Level.ALL);
		org.apache.log4j.Logger.getRootLogger().setLevel(Level.ALL);
	}

}
