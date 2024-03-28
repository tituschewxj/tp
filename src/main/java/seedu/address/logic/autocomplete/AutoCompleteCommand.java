package seedu.address.logic.autocomplete;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.commands.util.CommandWordUtil.getAllCommandWords;

import seedu.address.commons.util.Trie;

/**
 * Auto complete commands
 */
public class AutoCompleteCommand implements AutoComplete {
    private static Trie commandTrie;

    /**
     * Initializes the command trie with the given commands. This method should be called once at
     * the start of the initialization of LogicManager.
     *
     * @see seedu.address.logic.LogicManager
     */
    public static void initialize() {
        commandTrie = new Trie(getAllCommandWords());
    }

    @Override
    public String getAutoComplete(String input) {
        requireNonNull(commandTrie);
        String fullCommand = commandTrie.findFirstWordWithPrefix(input);

        assert fullCommand != null;
        if (fullCommand.isEmpty()) {
            return "";
        }

        // Strip the input from the full command
        return fullCommand.substring(input.length());
    }
}
