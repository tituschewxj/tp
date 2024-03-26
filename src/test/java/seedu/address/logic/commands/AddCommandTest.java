package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPersons.ALICE;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AddressBook;
import seedu.address.model.CourseName;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyCourseName;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.person.NusNet;
import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;


public class AddCommandTest {

    @Test
    public void constructor_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddPersonCommand(null));
    }

    @Test
    public void execute_personAcceptedByModel_addSuccessful() throws Exception {
        ModelStubAcceptingPersonAdded modelStub = new ModelStubAcceptingPersonAdded();
        Person validPerson = new PersonBuilder().build();

        CommandResult commandResult = new AddPersonCommand(validPerson).execute(modelStub);

        assertEquals(String.format(AddPersonCommand.MESSAGE_SUCCESS, Messages.format(validPerson)),
                commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(validPerson), modelStub.personsAdded);
    }

    @Test
    public void execute_duplicatePerson_throwsCommandException() {
        Person validPerson = new PersonBuilder().build();
        AddPersonCommand addCommand = new AddPersonCommand(validPerson);
        ModelStub modelStub = new ModelStubWithPerson(validPerson);

        assertThrows(CommandException.class,
                AddPersonCommand.MESSAGE_DUPLICATE_PERSON, () -> addCommand.execute(modelStub));
    }

    @Test
    public void equals() {
        Person alice = new PersonBuilder().withName("Alice").build();
        Person bob = new PersonBuilder().withName("Bob").build();
        AddPersonCommand addAliceCommand = new AddPersonCommand(alice);
        AddPersonCommand addBobCommand = new AddPersonCommand(bob);

        // same object -> returns true
        assertTrue(addAliceCommand.equals(addAliceCommand));

        // same values -> returns true
        AddPersonCommand addAliceCommandCopy = new AddPersonCommand(alice);
        assertTrue(addAliceCommand.equals(addAliceCommandCopy));

        // different types -> returns false
        assertFalse(addAliceCommand.equals(1));

        // null -> returns false
        assertFalse(addAliceCommand.equals(null));

        // different person -> returns false
        assertFalse(addAliceCommand.equals(addBobCommand));
    }

    @Test
    public void toStringMethod() {
        AddPersonCommand addCommand = new AddPersonCommand(ALICE);
        String expected = AddPersonCommand.class.getCanonicalName() + "{toAdd=" + ALICE + "}";
        assertEquals(expected, addCommand.toString());
    }
    // TODO
    // Abstract away the assertion errors below
    /**
     * A default model stub that have all the methods failing.
     */
    private class ModelStub implements Model {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            CustomAssertionError.throwDefault();
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            CustomAssertionError.throwDefault();
            return null;
        }

        @Override
        public GuiSettings getGuiSettings() {
            CustomAssertionError.throwDefault();
            return null;
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            CustomAssertionError.throwDefault();
        }

        @Override
        public Path getAddressBookFilePath() {
            CustomAssertionError.throwDefault();
            return null;
        }

        @Override
        public void setAddressBookFilePath(Path addressBookFilePath) {
            CustomAssertionError.throwDefault();
        }

        @Override
        public void addPerson(Person person) {
            CustomAssertionError.throwDefault();
        }

        @Override
        public void setAddressBook(ReadOnlyAddressBook newData) {
            CustomAssertionError.throwDefault();
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            CustomAssertionError.throwDefault();
            return null;
        }

        @Override
        public boolean hasPerson(Person person) {
            CustomAssertionError.throwDefault();
            return false;
        }

        @Override
        public void deletePerson(Person target) {
            CustomAssertionError.throwDefault();
        }

        @Override
        public void setPerson(Person target, Person editedPerson) {
            CustomAssertionError.throwDefault();
        }

        @Override
        public ObservableList<Person> getFilteredPersonList() {
            CustomAssertionError.throwDefault();
            return null;
        }

        @Override
        public void updateFilteredPersonList(Predicate<Person> predicate) {
            CustomAssertionError.throwDefault();
        }

        @Override
        public void changeCode(String code) {
            CustomAssertionError.throwDefault();
        }

        @Override
        public ReadOnlyStringProperty courseCodeProperty() {
            CustomAssertionError.throwDefault();
            return null;
        }

        @Override
        public Path getCourseNameFilePath() {
            CustomAssertionError.throwDefault();
            return null;
        }

        @Override
        public void setCourseNameFilePath(Path courseNameFilePath) {
            CustomAssertionError.throwDefault();
        }

        @Override
        public void setCourseName(ReadOnlyCourseName course) {
            CustomAssertionError.throwDefault();
        }

        @Override
        public CourseName getCourseName() {
            CustomAssertionError.throwDefault();
            return null;
        }


        public Optional<Person> getPersonByNusNet(NusNet nusNet) {
            CustomAssertionError.throwDefault();
            return Optional.empty();
        }
    }

    /**
     * A Model stub that contains a single person.
     */
    private class ModelStubWithPerson extends ModelStub {
        private final Person person;

        ModelStubWithPerson(Person person) {
            requireNonNull(person);
            this.person = person;
        }

        @Override
        public boolean hasPerson(Person person) {
            requireNonNull(person);
            return this.person.isSamePerson(person);
        }
    }

    /**
     * A Model stub that always accept the person being added.
     */
    private class ModelStubAcceptingPersonAdded extends ModelStub {
        final ArrayList<Person> personsAdded = new ArrayList<>();

        @Override
        public boolean hasPerson(Person person) {
            requireNonNull(person);
            return personsAdded.stream().anyMatch(person::isSamePerson);
        }

        @Override
        public void addPerson(Person person) {
            requireNonNull(person);
            personsAdded.add(person);
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            return new AddressBook();
        }
    }

}
