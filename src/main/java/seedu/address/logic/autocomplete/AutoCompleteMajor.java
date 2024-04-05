package seedu.address.logic.autocomplete;

import static seedu.address.logic.parser.CliSyntax.PREFIX_MAJOR;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import seedu.address.commons.util.Trie;

// TODO: code quality issues
/**
 * AutoComplete for major.
 */
public class AutoCompleteMajor implements AutoComplete {
    private static Trie majorTrie;
    private static final Pattern MAJOR_FORMAT = Pattern.compile(PREFIX_MAJOR.getPrefix() + "(.*)");

    /**
     * Initializes the major trie with the given majors. This method should be called once at
     * the start of the initialization of LogicManager.
     *
     * @param majors the majors to initialize the trie with
     */
    public static void initialize(String... majors) {
        majorTrie = new Trie(Arrays.stream(majors).toArray(String[]::new));
    }

    /**
     * Update the majors trie with the given majors. This method is just a wrapper for the
     * initialize method in Trie to make the intention clearer.
     *
     * @param majors the majors to update the trie with
     */
    public static void update(String... majors) {
        initialize(majors);
    }

    @Override
    public AutoCompleteResult getAutoComplete(String input) {
        assert majorTrie != null;

        Matcher m = MAJOR_FORMAT.matcher(input);
        boolean isMajor = m.find();
        assert isMajor;

        String partialMajor = m.group(1);
        List<String> fullMajors = majorTrie.findAllWordsWithPrefix(partialMajor);

        assert fullMajors != null;
        if (fullMajors.isEmpty()) {
            return new AutoCompleteResult();
        }

        // Strip the input from the full commands and sort the list
        return new AutoCompleteResult(
                fullMajors.stream()
                    .map(c -> c.substring(partialMajor.length()))
                    .sorted()
                    .collect(Collectors.toList())
        );
    }
}
