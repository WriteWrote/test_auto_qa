package org.example.task1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

public class MethodInterceptionTest {
    private final MethodInterception service = new MethodInterception();

    @Test
    public void annotationValue() {
        MainPage mainPage = service.createPage(MainPage.class);
        assertNotNull(mainPage);
        assertEquals(mainPage.buttonSearch(), ".//*[@test-attr='button_search']");
        assertEquals(mainPage.textInputSearch(), ".//*[@test-attr='input_search']");
    }
}
