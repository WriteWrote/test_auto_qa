package org.example.task1;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

import static org.junit.jupiter.api.Assertions.*;

class MethodInterceptionTest {
//    private final MethodInterception service = mock(MethodInterception.class);
    private final MethodInterception service = new MethodInterception();

    @Test
    public void annotationValue() {
        MainPage mainPage = service.createPage(MainPage.class);
        assertNotNull(mainPage);
        assertEquals(mainPage.buttonSearch(), ".//*[@test-attr='button_search']");
        assertEquals(mainPage.textInputSearch(), ".//*[@test-attr='input_search']");
    }
}
