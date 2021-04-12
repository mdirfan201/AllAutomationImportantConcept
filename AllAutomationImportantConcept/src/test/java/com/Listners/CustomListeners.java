package com.Listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.utility.screenShot;

public class CustomListeners extends TakeFailureOnluScreeShots implements ITestListener {
	
	@Override
		public  void onTestStart(ITestResult result) {
	    
	  }
	
	@Override
		public void onTestSuccess(ITestResult result) {
			   
		  }

	@Override	  
		public void onTestFailure(ITestResult result) {
		failed(result.getMethod().getMethodName());
		//captureScreenshots(result.getMethod().getMethodName());
	  }
	
	@Override
		public  void onTestSkipped(ITestResult result) {
		    // not implemented
		  }

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
