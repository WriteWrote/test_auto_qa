package org.example.task2;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
//        ITestListener.super.onTestStart(result);
        System.out.println("!!!! Listener !!!! " + result.getTestName());
    }

    @Override
    public void onStart(ITestContext context) {
//        ITestListener.super.onStart(context);
        System.out.println("Test start");
    }
}
