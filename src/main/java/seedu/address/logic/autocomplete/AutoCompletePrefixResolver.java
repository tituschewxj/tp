package seedu.address.logic.autocomplete;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import seedu.address.logic.parser.Prefix;

/**
 * Autocomplete resolves autocompletion results of its patterns.
 * <p>
 * Autocomplete resolver only needs to fetch data from a store when that prefix is being autocompleted.
 */
public class AutoCompletePrefixResolver implements AutoComplete {
    /** The prefix resolvers used when generating the result */
    private final PrefixResolver[] prefixResolvers;

    /**
     * Creates a new resolver to resolve the autocomplete suggestions,
     * based on the provided prefixes.
     *
     * @param prefixResolvers The prefixes used to generate the result.
     */
    public AutoCompletePrefixResolver(PrefixResolver... prefixResolvers) {
        assert prefixResolvers != null;
        this.prefixResolvers = prefixResolvers;
    }

    @Override
    public AutoCompleteResult getAutoComplete(String input) {
        assert input != null;
        if (input.isBlank()) {
            return new AutoCompleteResult();
        }

        List<String> trieMatchContinuations = findTriePrefixContinuation(input);

        assert trieMatchContinuations != null;
        if (trieMatchContinuations.isEmpty()) {
            return new AutoCompleteResult();
        }

        return new AutoCompleteResult(trieMatchContinuations);
    }

    /**
     * Finds the matches in the trie that matches prefixes based on the input.
     *
     * @param input The input string to search in.
     * @return The list of sorted strings that continues after the prefixes.
     */
    private List<String> findTriePrefixContinuation(String input) {
        int indexOfLastPrefix = findLastPrefixIndex(input);
        if (indexOfLastPrefix == -1) {
            return List.of();
        }

        Prefix lastPrefix = findLastPrefix(input, indexOfLastPrefix);
        if (lastPrefix == null) {
            return List.of();
        }

        String partialValue = input.substring(indexOfLastPrefix + lastPrefix.getPrefix().length());

        // Resolve prefixes, strip the input, and sort the list
        return Arrays.stream(prefixResolvers)
                .filter(pr -> pr.getPrefix().equals(lastPrefix))
                .map(pr -> pr.resolvePrefix(partialValue))
                .findAny()
                .orElse(List.of())
                .stream()
                .map(c -> c.substring(partialValue.length())) // Strip input
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Finds the last prefix in the input, given its index.
     *
     * @param input The input string to search in.
     * @param indexOfLastPrefix The index of the last prefix.
     * @return The last prefix in the input.
     */
    private Prefix findLastPrefix(String input, int indexOfLastPrefix) {
        assert indexOfLastPrefix >= 0 && indexOfLastPrefix < input.length();

        String finalPrefixString = input.substring(indexOfLastPrefix);

        return Arrays.stream(prefixResolvers)
                .map(PrefixResolver::getPrefix)
                .filter(p -> finalPrefixString.startsWith(p.getPrefix()))
                .findAny()
                .orElse(null);
    }

    /**
     * Finds the last prefix index from the input string.
     *
     * @param input The input string to search in.
     * @return The last index of the prefix if it exists, otherwise -1.
     */
    private int findLastPrefixIndex(String input) {
        return Arrays
                .stream(prefixResolvers)
                .map(PrefixResolver::getPrefix)
                .map(p -> " " + p.getPrefix()) // Match prefix with space in front.
                .mapToInt(p -> input.lastIndexOf(p) + 1)
                .max()
                .orElse(-1);
    }
}
