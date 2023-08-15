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
        ServiceLoader<TestMethodInfoTest> loader = ServiceLoader.load(TestMethodInfoTest.class);
//        for (TestMethodInfo t : loader){
//            System.out.println(t.author());
//        }
//        var pngFactories = loader
//                .stream()                                              // Note a below
//                .filter(p -> p.type().isAnnotationPresent(TestMethodInfo.class))  // Note b
//                .map(ServiceLoader.Provider::get)                                    // Note c
//                .collect(Collectors.toSet());


//        for (Method m : TestMethodInfoTest.class.getMethods()) {
//            TestMethodInfo annotation = m.getAnnotation(TestMethodInfo.class);
//            if (annotation != null)
//                for (var a : annotation.getClass().getMethods()) {
//                    System.out.println(a.toGenericString());
//                }
//        }

        assertEquals(1, 1);
    }
}
