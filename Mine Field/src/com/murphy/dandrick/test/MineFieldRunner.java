package com.murphy.dandrick.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MineFieldRunner {

	public static void main(String[] args) {
	      Result result = JUnitCore.runClasses(MineFieldTest.class);
			
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
			
	      System.out.println("All test successful? " + result.wasSuccessful());
	   }
}
