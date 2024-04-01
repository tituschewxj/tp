package seedu.address.logic.autocomplete;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AutoCompleteCommandTest {
    /**
     * Test that the getAutoComplete method returns the correct autocomplete text.
     */
    @Test
    void getAutoComplete() {
        // Initialize the command trie with some random commands
        AutoCompleteCommand.initialize();

        AutoComplete autoComplete = new AutoCompleteCommand();
        // Test for a command that is not in the trie
        assertEquals("", autoComplete.getAutoComplete("xdddd").getNextResult());

        // Test for a command that is in the trie
        assertEquals("it", autoComplete.getAutoComplete("ed").getNextResult());
    }
}
