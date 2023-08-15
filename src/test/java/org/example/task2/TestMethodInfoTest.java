package org.example.task2;

import org.junit.jupiter.api.TestInfo;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.Set;

import static org.testng.Assert.assertEquals;

//@Listeners(PlaygroundListener.class)
public class TestMethodInfoTest {
    @Test
    @TestMethodInfo(priority = Priority.Critical, author = "Ellina Obukhova", lastModified = "15.08.2023")
    public void annotation() {
        ServiceLoader<PlaygroundListener> loader = ServiceLoader.load(PlaygroundListener.class);
        Optional<PlaygroundListener> listener = loader.findFirst();

        ITestResult currentTestResult = getCorrespondingResultFor(testContext.getTestMethod());

        listener.ifPresent(playgroundListener -> playgroundListener.onTestStart(currentTestResult));

        int result = Reporter.getCurrentTestResult().getStatus();
        assertEquals(1, 1);
    }

    private ITestResult getCorrespondingResultFor(Method method) {
        ITestContext context = Reporter.getCurrentTestResult().getTestContext();
        Set<ITestResult> allResults = new HashSet<>();

        allResults.addAll(context.getPassedTests().getAllResults());
        allResults.addAll(context.getFailedTests().getAllResults());
        allResults.addAll(context.getSkippedTests().getAllResults());

        return allResults
                .stream()
                .filter(result -> result.getMethod().getConstructorOrMethod().getMethod().equals(method))
                .findAny()
                .orElse(null);
    }
}
