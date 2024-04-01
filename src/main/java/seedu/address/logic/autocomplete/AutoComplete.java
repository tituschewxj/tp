package seedu.address.logic.autocomplete;

/**
 * API of the Autocomplete component
 */
public interface AutoComplete {
    /**
     * Returns the autocomplete result based on the input.
     *
     * @param input The input as entered by the user.
     * @return the autocomplete result to be appended to the input.
     */
    AutoCompleteResult getAutoComplete(String input);
}
