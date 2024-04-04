package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MAJOR;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NUSNET;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.Set;

import seedu.address.logic.commands.AddPersonCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Email;
import seedu.address.model.person.Major;
import seedu.address.model.person.Name;
import seedu.address.model.person.NusNet;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;
/**
 * Parses input arguments and creates a new AddPersonCommand object
 */
public class AddPersonCommandParser implements Parser<AddPersonCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddPersonCommand
     * and returns an AddPersonCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddPersonCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(
                args,
                PREFIX_NAME,
                PREFIX_PHONE,
                PREFIX_EMAIL,
                PREFIX_NUSNET,
                PREFIX_MAJOR,
                PREFIX_TAG
        );

        if (!ArgumentMultimap.arePrefixesPresent(
            argMultimap,
            PREFIX_NAME,
            PREFIX_NUSNET
        ) || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddPersonCommand.MESSAGE_USAGE));
        }

        argMultimap.verifyNoDuplicatePrefixesFor(
                PREFIX_NAME,
                PREFIX_PHONE,
                PREFIX_EMAIL,
                PREFIX_NUSNET,
                PREFIX_MAJOR
        );

        Name name = ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME)
             .get());
        Phone phone = ParserUtil.parsePhone(argMultimap.getValue(PREFIX_PHONE)
             .orElseGet(() -> Phone.PLACEHOLDER));
        Email email = ParserUtil.parseEmail(argMultimap.getValue(PREFIX_EMAIL)
             .orElseGet(() -> Email.PLACEHOLDER));
        NusNet nusNet = ParserUtil.parseNusNet(argMultimap.getValue(PREFIX_NUSNET)
              .get());
        Major major = ParserUtil.parseMajor(argMultimap.getValue(PREFIX_MAJOR)
              .orElseGet(() -> Major.PLACEHOLDER));
        Set<Tag> tagList = ParserUtil.parseTags(argMultimap.getAllValues(PREFIX_TAG));

        Person person = new Person(name, phone, email, nusNet, major, tagList);

        return new AddPersonCommand(person);
    }
}
