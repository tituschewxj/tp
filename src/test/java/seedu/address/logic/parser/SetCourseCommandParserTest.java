package seedu.address.logic.parser;

import static seedu.address.logic.commands.CommandTestUtil.VALID_COURSE_CODE_CS2103T;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.SetCourseCommand;
import seedu.address.model.course.Course;


public class SetCourseCommandParserTest {
    private SetCourseCommandParser parser = new SetCourseCommandParser();

    @Test
    public void parse_validArgs_returnsSetCourseCommand() {

        Course expectedCourse = new Course(VALID_COURSE_CODE_CS2103T);
        SetCourseCommand expectedSetCourseCommand = new SetCourseCommand(expectedCourse);

        assertParseSuccess(parser, VALID_COURSE_CODE_CS2103T, expectedSetCourseCommand);

        // Correct input format with multiple whitespaces between keywords
        assertParseSuccess(parser, VALID_COURSE_CODE_CS2103T + "  ", expectedSetCourseCommand);
    }
}
