package org.example.task2;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ServiceLoader;

import static org.testng.Assert.assertEquals;

//import static org.junit.jupiter.api.Assertions.assertEquals;

@Listeners(MyListener.class)
public class TestMethodInfoTest {
    @Test
    @TestMethodInfo(priority = Priority.Critical, author = "Test user", lastModified = "20.08.2019")
    public void annotation() {
        assertEquals(1, 1);
    }
}
