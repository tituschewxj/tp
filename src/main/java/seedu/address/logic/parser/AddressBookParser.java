package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.Messages.MESSAGE_UNKNOWN_COMMAND;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MAJOR;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NUSNET;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.autocomplete.AutoComplete;
import seedu.address.logic.autocomplete.AutoCompleteCommand;
import seedu.address.logic.autocomplete.AutoCompleteEmail;
import seedu.address.logic.autocomplete.AutoCompleteMajor;
import seedu.address.logic.autocomplete.AutoCompleteName;
import seedu.address.logic.autocomplete.AutoCompleteNusNetId;
import seedu.address.logic.autocomplete.AutoCompletePhone;
import seedu.address.logic.autocomplete.AutoCompleteResult;
import seedu.address.logic.autocomplete.AutoCompleteTag;
import seedu.address.logic.commands.AddPersonCommand;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.DeletePersonCommand;
import seedu.address.logic.commands.EditPersonCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.FindPersonCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.ListPersonCommand;
import seedu.address.logic.commands.MarkAttendanceCommand;
import seedu.address.logic.commands.SetCourseCommand;
import seedu.address.logic.commands.UnmarkAttendanceCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses user input.
 */
public class AddressBookParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");
    private static final Pattern NUSNET_ID_FORMAT = Pattern.compile(" " + PREFIX_NUSNET + "(.*)");
    private static final Pattern MAJOR_FORMAT = Pattern.compile(" " + PREFIX_MAJOR + "(.*)");
    private static final Pattern TAG_FORMAT = Pattern.compile(" " + PREFIX_TAG + "(.*)");
    private static final Pattern NAME_FORMAT = Pattern.compile(" " + PREFIX_NAME + "(.*)");
    private static final Pattern PHONE_FORMAT = Pattern.compile(" " + PREFIX_PHONE + "(.*)");
    private static final Pattern EMAIL_FORMAT = Pattern.compile(" " + PREFIX_EMAIL + "(.*)");
    private static final Logger logger = LogsCenter.getLogger(AddressBookParser.class);
    private static final String COMMAND_WORD_GROUP = "commandWord";
    private static final String ARGUMENTS_GROUP = "arguments";

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group(COMMAND_WORD_GROUP);
        final String arguments = matcher.group(ARGUMENTS_GROUP);

        // Note to developers: Change the log level in config.json to enable lower level
        // (i.e., FINE, FINER and lower)
        // log messages such as the one below.
        // Lower level log messages are used sparingly to minimize noise in the code.
        logger.fine("Command word: " + commandWord + "; Arguments: " + arguments);

        switch (commandWord) {

        case AddPersonCommand.COMMAND_WORD:
            return new AddPersonCommandParser().parse(arguments);

        case EditPersonCommand.COMMAND_WORD:
            return new EditPersonCommandParser().parse(arguments);

        case DeletePersonCommand.COMMAND_WORD:
            return new DeletePersonCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();

        case FindPersonCommand.COMMAND_WORD:
            return new FindPersonCommandParser().parse(arguments);

        case ListPersonCommand.COMMAND_WORD:
            return new ListPersonCommand();

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        case SetCourseCommand.COMMAND_WORD:
            return new SetCourseCommandParser().parse(arguments);

        case MarkAttendanceCommand.COMMAND_WORD:
            return new MarkAttendanceCommandParser().parse(arguments);

        case UnmarkAttendanceCommand.COMMAND_WORD:
            return new UnmarkAttendanceCommandParser().parse(arguments);

        default:
            logger.finer("This user input caused a ParseException: " + userInput);
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

    /**
     * Parses the full input text and returns the appropriate autocomplete object.
     */
    public AutoComplete parseAutoComplete(String userInput) {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            logger.finer("Unable to parse user input for autocomplete: " + userInput);
            return input -> new AutoCompleteResult();
        }

        final String arguments = matcher.group(ARGUMENTS_GROUP);

        // no arguments, return autocomplete for command word
        if (arguments.isEmpty()) {
            return new AutoCompleteCommand();
        }

        // TODO: code quality issues?
        // Take the last prefix that appears for autocomplete
        int lastIndex = -1;
        if (MAJOR_FORMAT.matcher(arguments).find()) {
            lastIndex = Math.max(lastIndex, userInput.indexOf(" " + PREFIX_MAJOR));
        }
        if (NUSNET_ID_FORMAT.matcher(arguments).find()) {
            lastIndex = Math.max(lastIndex, userInput.indexOf(" " + PREFIX_NUSNET));
        }
        if (TAG_FORMAT.matcher(arguments).find()) {
            lastIndex = Math.max(lastIndex, userInput.indexOf(" " + PREFIX_TAG));
        }
        if (EMAIL_FORMAT.matcher(arguments).find()) {
            lastIndex = Math.max(lastIndex, userInput.indexOf(" " + PREFIX_EMAIL));
        }
        if (NAME_FORMAT.matcher(arguments).find()) {
            lastIndex = Math.max(lastIndex, userInput.indexOf(" " + PREFIX_NAME));
        }
        if (PHONE_FORMAT.matcher(arguments).find()) {
            lastIndex = Math.max(lastIndex, userInput.indexOf(" " + PREFIX_PHONE));
        }

        // Check which prefix appears later
        if (lastIndex == -1) {
            return input -> new AutoCompleteResult();
        }
        if (userInput.substring(lastIndex).startsWith(" " + PREFIX_MAJOR)) {
            return new AutoCompleteMajor();
        }
        if (userInput.substring(lastIndex).startsWith(" " + PREFIX_NUSNET)) {
            return new AutoCompleteNusNetId();
        }
        if (userInput.substring(lastIndex).startsWith(" " + PREFIX_TAG)) {
            return new AutoCompleteTag();
        }
        if (userInput.substring(lastIndex).startsWith(" " + PREFIX_PHONE)) {
            return new AutoCompletePhone();
        }
        if (userInput.substring(lastIndex).startsWith(" " + PREFIX_EMAIL)) {
            return new AutoCompleteEmail();
        }
        if (userInput.substring(lastIndex).startsWith(" " + PREFIX_NAME)) {
            return new AutoCompleteName();
        }

        return input -> new AutoCompleteResult();
    }
}
