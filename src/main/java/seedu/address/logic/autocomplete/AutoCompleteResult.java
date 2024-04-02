package seedu.address.logic.autocomplete;

import java.util.List;

/**
 * Stores the result of running the {@link AutoCompleteCommand}.
 * <p>
 * The result is an empty string if there is no result.
 * <p>
 * The result are the rest of the possible strings after the prefix if results exist.
 */
public class AutoCompleteResult {
    final List<String> results;

    /** The internal pointer to the current result */
    private int currentIndex;

    /**
     * Creates an autocomplete result given a results list.
     */
    public AutoCompleteResult(List<String> results) {
        this.results = results;
        currentIndex = 0;
    }

    /**
     * Creates an autocomplete result that doesn't have a result.
     */
    public AutoCompleteResult() {
        results = List.of();
        currentIndex = 0;
    }

    /**
     * Gets the next result in from the circular results list
     * and increments an internal pointer to the next result,
     * if there is a result.
     */
    public String getNextResult() {
        assert results != null;

        if (results.isEmpty()) {
            return "";
        }

        String currentResult = results.get(currentIndex);
        currentIndex = (currentIndex + 1) % results.size();

        if (currentResult == null) {
            return "";
        }

        return currentResult;
    }
}
