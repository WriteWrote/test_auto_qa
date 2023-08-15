package org.example.task2;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners(PlaygroundListener.class)
public class TestMethodInfoTest {
    @Test
    @TestMethodInfo(priority = Priority.Critical, author = "Ellina Obukhova", lastModified = "15.08.2023")
    public void annotation() {
        assertEquals(1, 1);
    }
}
