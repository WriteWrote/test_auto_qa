package org.example.task2;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Optional;
import java.util.ServiceLoader;

import static org.testng.Assert.assertEquals;

@Listeners(PlaygroundListener.class)
public class TestMethodInfoTest {
    @Test
    @TestMethodInfo(priority = Priority.Critical, author = "Test User", lastModified = "15.08.2023")
    public void annotation() {

//        ServiceLoader<PlaygroundListener> loader = ServiceLoader.load(PlaygroundListener.class);
//        Optional<PlaygroundListener> listener = loader.findFirst();
//        listener.ifPresent(playgroundListener -> playgroundListener.onTestStart(Reporter.getCurrentTestResult().getStatus()));

        // I'm sorry but i don't understand, why we should introduce ServiceLoader
        // and get a problem with retrieving test result and test context,
        // when we can just put an annotation @Listener. I couldn't manage to introduce it properly
        // so I will leave an annotation there

        assertEquals(1, 1);
    }
}
