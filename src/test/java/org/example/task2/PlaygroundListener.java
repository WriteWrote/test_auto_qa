package org.example.task2;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.lang.reflect.Method;

public class PlaygroundListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        System.out.println("Test with name \"" + result.getName() + "\" started");

        Method method = result.getMethod().getConstructorOrMethod().getMethod();        // this is ugly, but so be it
        TestMethodInfo annotation = method.getAnnotation(TestMethodInfo.class);

        // it would be good to use a smart way to define which parameters should method print,
        // but I don't know how to do it, so it will be just printed
        System.out.println("\nTestMethodInfo parameters:");

        System.out.println("    Author: " + annotation.author());
        System.out.println("    Last modified: " + annotation.lastModified());
        System.out.println("    Priority: " + annotation.priority());

        System.out.println("\n");
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
        System.out.println("\n" + context.getName() + " started");
    }
}
