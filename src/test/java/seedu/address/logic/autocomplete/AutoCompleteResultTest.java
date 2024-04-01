package seedu.address.logic.autocomplete;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class AutoCompleteResultTest {

    @Test
    void getNextResult() {
        AutoCompleteResult result = new AutoCompleteResult(Arrays.asList("abc", "def", "", "123", null));
        assertEquals("abc", result.getNextResult());
        assertEquals("def", result.getNextResult());
        assertEquals("", result.getNextResult());
        assertEquals("123", result.getNextResult());
        assertEquals("", result.getNextResult());
        assertEquals("abc", result.getNextResult());
    }

    @Test
    void getNextResult_emptyResult() {
        AutoCompleteResult result = new AutoCompleteResult();
        assertEquals("", result.getNextResult());
        assertEquals("", result.getNextResult());
    }
}
