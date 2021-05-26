package com.mph.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class RunnerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hi");
		Result result =JUnitCore.runClasses(AllMyTestSuite.class);
        for(Failure fa:result.getFailures())
        {
            System.out.println("Failure result " +fa.toString());
        }
        System.out.println("Success result :" + result.wasSuccessful());
	}

}
