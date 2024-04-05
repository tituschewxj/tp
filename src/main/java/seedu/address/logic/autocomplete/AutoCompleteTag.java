package seedu.address.logic.autocomplete;

import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import seedu.address.commons.util.Trie;

// TODO: code quality issues
/**
 * AutoComplete for tag.
 */
public class AutoCompleteTag implements AutoComplete {
    private static Trie tagTrie;
    private static final Pattern TAG_FORMAT = Pattern.compile("(" + PREFIX_TAG.getPrefix() + "(.*))?");

    /**
     * Initializes the tags trie with the given majors. This method should be called once at
     * the start of the initialization of LogicManager.
     *
     * @param majors the tags to initialize the trie with
     */
    public static void initialize(String... majors) {
        tagTrie = new Trie(Arrays.stream(majors).toArray(String[]::new));
    }

    /**
     * Update the tags trie with the given tags. This method is just a wrapper for the
     * initialize method in Trie to make the intention clearer.
     *
     * @param majors the tags to update the trie with
     */
    public static void update(String... majors) {
        initialize(majors);
    }

    @Override
    public AutoCompleteResult getAutoComplete(String input) {
        assert tagTrie != null;

        Matcher m = TAG_FORMAT.matcher(input);
        boolean isTag = m.find();
        assert isTag;

        // match last group (non-greedy match)
        String partialTags = m.group(0);

        List<String> fullTags = tagTrie.findAllWordsWithPrefix(partialTags);

        assert fullTags != null;
        if (fullTags.isEmpty()) {
            return new AutoCompleteResult();
        }

        // Strip the input from the full commands and sort the list
        return new AutoCompleteResult(
                fullTags.stream()
                    .map(c -> c.substring(partialTags.length()))
                    .sorted()
                    .collect(Collectors.toList())
        );
    }
}
