package org.example.task2;

import org.example.task2.Priority;
import org.example.task2.TestMethodInfo;
import org.junit.jupiter.api.Test;

import java.util.ServiceLoader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMethodInfoTest {
    @Test
    @TestMethodInfo(priority = Priority.Critical, author = "Test user", lastModified = "20.08.2019")
    public void annotation() {
        ServiceLoader<TestMethodInfo> loader = ServiceLoader.load(TestMethodInfo.class);
        assertEquals(1, 1);
    }
}
