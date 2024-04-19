package com.test.practise;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersMethodOverriding implements ITestListener {

	@Override
	public void onStart(ITestContext context) {

		context.getName();

	}

	@Override
	public void onFinish(ITestContext context) {

		context.getName();

	}

	

	@Override
	public void onTestStart(ITestResult result) {
		
		
		result.getMethod().getMethodName();
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		
		
		result.getMethod().getMethodName();
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		
		result.getMethod().getMethodName();
	}
	
	
	@Override
	public void onTestSkipped(ITestResult result) {
		
		
		result.getMethod().getMethodName();
	}
}
