---
  layout: default.md
  title: "User Guide"
  pageNav: 3
---

# TAPro User Guide
<p align="center">
    <img src="images/TAProLogo.jpg" alt="TAPro Logo" class="rounded-image" width="500px"/>
</p>

TAPro is your go-to **Contact Book application**, created with love for **Computer Science Teaching Assistants (TAs)** like you. _We get it_ — juggling your students and keeping track of attendance can be a handful. That’s why TAPro is 
here to make your life easier. With features designed preciesly for you, it's all about simplifying those 
time-consuming tasks, letting you focus on what you do best: teaching and inspiring your students. Welcome to a 
smoother, more personalized way of managing your TA duties!

TAPro is optimized for use via a **Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). 

If you can type fast, TAPro can get your contact management and attendance taking tasks done **faster** 🚀 than traditional GUI apps. 

<!-- * Table of Contents -->
<page-nav-print />

{{ newPage }}

## <i class="fa-solid fa-forward"></i>  Navigating this User Guide

Welcome to the cozy corner of the TAPro User Guide! 🌟 Whether you're embarking on your very first day as a TA or 
you're practically a wizard with student info, we've put together this guide to make sure you get the most out of TAPro.

🚀 **Ready to Roll?** Skip over to **[Quick Start](#quick-start)** for the no-fuss, easy-peasy steps to download TAPro and get ready for 
action.

**New around here?** No worries, we've got you. Start with these sections to become a TAPro buddy in no time:

- [Navigating the GUI](#navigating-the-gui): Familiarize yourself with the command box and those handy contact cards. 
- [Features](#features): Dive into the exciting world of features we've brewed up just for you.

**Already a TAPro champ?** Let's add some spice to your TA skills:

- **[Set Course](#name-rename-cs-course-setcrs)**: Tailor TAPro to your current course with `setcrs`.
- **[Add Student](#adding-a-student-addstu)**: Got a new face in class? Quickly add their details with `addstu`.
- **[Mark](#marking-a-student-s-attendance-for-a-given-week-by-their-nusnet-mark)**: Keep track of weekly attendance with `mark`.
- **[Unmark](#unmarking-a-student-s-attendance-for-a-given-week-by-their-nusnet-unmark)**: Oops, made a mistake? `unmark` reverses that mark.
- **[List](#listing-all-students-list)**: Bring up a complete list of your students with `list`.
- **[Edit](#editing-a-student-edit)**: Update details as they evolve with `edit`.
- **[Find](#locating-students-by-name-find)**: Looking for someone? find helps you search by keyword.
- **[Delete Student](#deleting-a-student-delstu)**: Time to say goodbye? Remove a student from your list with `delstu`.
- **[Clear](#clearing-all-entries-clear)**: Need to wipe the slate clean? `clear` does just that.

**Need a quick TAPro refresher?** Our Command Summary is like the TAPro bible—short, sweet, and to the point.

Stumbled upon a hurdle or just curious? Swing by our **[FAQ](#faq)** where we tackle all your burning questions and offer 
nuggets of wisdom for a smooth TAPro journey.
{{ newPage }}

## <i class="fa-solid fa-forward"></i> Useful Notations and Glossary

Diving into TAPro, you'll encounter some handy notations and terms. We've decoded them here to make your journey smoother and more enjoyable:

### Symbols

| Symbol                                               | Meaning                                                |
|------------------------------------------------------|--------------------------------------------------------|
| <i class="fa-solid fa-lightbulb text-success"></i>   | Tip                                                    |
| <i class="fa-solid fa-exclamation text-warning"></i> | Warning                                                |
| <i class="fa-solid fa-flag text-danger"></i>         | Important                                              |
| <i class="fa-solid fa-info text-info"></i>           | Additional useful information                          |
| <i class="fa-solid fa-check text-success"></i>       | Valid Example                                          |
| <i class="fa-solid fa-x text-danger"></i> | Invalid Example                                        |
| <i class="fa-solid fa-exclamation text-danger"></i>  | Danger                                                 |
| <i class="fa-solid fa-book text-primary"></i> | Definition |
| <i class="fa-solid fa-question text-info"></i> | Question |
| **`UPPER_CASE`**                                     | Represents parameters that need to be given by you!    |
| **... (Ellipsis)**                                   | Indicates that a parameter can be repeated or omitted entirely. |
| **[Square Brackets]**                                | Denotes optional parameters.                           |

### Keywords 

| Keywords                           | Meaning                                                                                  |
|------------------------------------|------------------------------------------------------------------------------------------|
| **Command Line Interface**   | A text-based interface used for entering commands directly.                              |
| **Graphical User Interface** | The visual interface that enhances user interaction with graphical elements.             |
| **Parameters**                     | Specific pieces of information required by commands to execute a function.               |
| **Attribute** | A single detail of a student. |
| **INDEX**                          | A case-insensitive, unique identification code assigned to each student.                                       |
| **NUSNET**                      | A unique identification code assigned to each student.                                   |
| **TAG**                            | A one-word, case-insensitive, label that can be associated with a student for categorization.             |
| **Autocomplete**                   | A feature that predicts and completes commands as you type.                              |
| **Command History**                | A record of successfully executed commands that can be retrieved for reuse.              |

### Abbreviations

| Abbreviation | Meaning                                                                 |
|-------------|-------------------------------------------------------------------------|
| **ASCII** | American Standard Code for Information Interchange                      |
| **GUI**     | Graphical User Interface                                                |
| **CLI**     | Command Line Interface                                                  |
| **TA**      | Teaching Assistant                                                     |
| **CS**      | Computer Science                                                       |
| **NUS**     | National University of Singapore |
| **URL**     | Uniform Resource Locator                                                |
| **JSON**    | JavaScript Object Notation                                              |

### Recognised Prefixes for Attributes
| Prefix | Attribute |
|--------|-----------------------------|
| **n/** | Name of the student         |
| **nn/** | NUSNet of the student       |
| **p/** | Phone number of the student |
| **e/** | Email of the student        |
| **m/** | Major of the student        |
| **t/** | Tag of the student          |
| **wk/** | Week number for attendance  |

This segment aims to make your TAPro experience as smooth as silk. With these notions and terms at your fingertips, you're well on your way to becoming a TAPro power user!

{{ newPage }}

## <i class="fa-solid fa-forward"></i> Navigating the GUI

Welcome to the TAPro GUI! 🎉 Here's a quick tour to help you get comfortable with the interface:

TODO: Add a screenshot of the GUI with annotations


## <i class="fa-solid fa-forward"></i> Quick start

1. Ensure you have Java 11 or above installed in your computer.

<box type="tip" seamless>

<i class="fa-solid fa-download"></i>
**Installing Java:**

If you do not have Java 11 or above installed, you can download the latest available version of Java from [here](https://www.oracle.com/sg/java/technologies/downloads/).
The latest version is compatible with older versions.

</box>

2. Download the latest version of `TAPro.jar` from [here](https://github.com/AY2324S2-CS2103T-F13-1/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your TAPro.

1. Open a command terminal, `cd` into the folder you downloaded the jar file in, and run the `java -jar TAPro.jar` command to launch the application.

<box type="info" seamless>

A GUI similar to the below image should appear in a few seconds. Note how the app contains some sample data.

<img alt="Main Window UI on first launch" src="images/main_window_ui.png" class="rounded-image" />

</box>
<div style="page-break-after: always;"></div>

5. Type the command in the command box and press <span class="badge bg-light text-dark">Enter</span> to execute it. e.g. typing **`help`** and pressing <span class="badge bg-light text-dark">Enter</span> will open the help window.

<box type="info" seamless>

**Here are some example commands you can try:**

* `list` : Lists all contacts.

* `addstu nn/e0952224 n/John Doe p/98765432 e/johnd@example.com m/Computer Science` : Adds a student named `John Doe` to the contact book.

* `delstu nn/NUSNET_ID` : Deletes the student with the specified `NUSNET_ID` from the contact book.

* `clear` : Deletes all students, and their contact and attendance information.

* `exit` : Exits the application.

</box>

6. Refer to the sections under [Features](#features) below for details of each command.

<markdown class="d-print-none">---</markdown>
<div style="page-break-after: always;"></div>
<br>

## <i class="fa-solid fa-font-awesome"></i> Features

<box type="info" seamless>

**About the command format:**<br>

<box type="success" seamless>

<span class="semi-bold">Words in `UPPER_CASE` are the parameters to be supplied by the user.</span>

<span class="semi-bold">#g#Example:##</span> In `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.
</box>


<box type="success" seamless>

<span class="semi-bold">Items in square brackets are optional.</span>

<span class="semi-bold">#g#Example:##</span> `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.
</box>

<box type="success" seamless>

<span class="semi-bold">Items with `…`​ after them can be used multiple times including zero times.</span>

<span class="semi-bold">#g#Example:##</span> `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.
</box>


<box type="success" seamless>

<span class="semi-bold">Parameters can be in any order.</span>

<span class="semi-bold">#g#Example:##</span> If the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.
</box>

<box type="success" seamless>

<span class="semi-bold">Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.</span>

<span class="semi-bold">#g#Example:##</span> If the command specifies `help 123`, it will be interpreted as `help`.
</box>

</box>

<box type="warning" seamless>

**If you are using a PDF version of this document:**

Be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
</box>

<markdown class="d-print-none">---</markdown>
<div style="page-break-after: always;"></div>
<br>





### <i class="fa-solid fa-circle-question"></i> Viewing help : `help`

Entering the `help` command opens a help window that shows a message explaining how to access the help page, 
as well as quick reference of each command with simple examples on how to use them.

Format: `help`

<box type="info" seamless>

<i class="fa-regular fa-window-restore"></i>
**A new window is opened:**

A new window is opened, so that it does not clutter up your main window. A GUI similar to the below image should appear.

<img src="images/help_window_ui.png" alt="Help Window UI" class="rounded-image" width="800px"/>

</box>

<box type="tip" seamless>

<i class="fa-solid fa-maximize"></i>
**Resizing the help window:**

The help window is resizable, so you can **easily reposition and resize** it to fit anywhere on your screen, exactly where you want it to be.
</box>

<box type="tip" seamless>

<i class="fa-solid fa-window-restore"></i>
**Switching quickly between the help and main window:**

* On Windows and most Linux distributions, you can use the keyboard shortcut: <span class="badge bg-light text-dark">Alt</span> +  <span class="badge bg-light text-dark">Tab</span>, to switch between windows quickly. 

* On macOS, you can use the keyboard shortcut: <span class="badge bg-light text-dark">Cmd⌘</span> + <span class="badge bg-light text-dark">Tab</span>, to switch between windows quickly.

</box>

<box type="info" seamless>

**More about help's quick reference:**

The quick reference is meant for **fast and reliable** lookup of commands and their usages, without needing an internet connection and opening a browser to get an overview of the commands.

* It is not meant to contain detailed information about each command. To access detailed information about each command, you can refer to our user guide.
</box>

<markdown class="d-print-none">---</markdown>
<div style="page-break-after: always;"></div>
<br>

### <i class="fa-solid fa-chalkboard"></i> Name/Rename CS course : `setcrs`

Names the course in question. 

Format: `setcrs COURSE_NAME`

Duplicate course are not allowed.
Courses are case-insensitive.
Course code should follow the format "XX1234Y", Y is optional.

<markdown class="d-print-none">---</markdown>
<div style="page-break-after: always;"></div>
<br>

### <i class="fa-solid fa-user-plus"></i> Adding a student: `addstu`
Adds a student to the contact book.

Format: `addstu n/NAME nn/NUSNET [p/PHONE] [e/EMAIL] [m/MAJOR] [t/TAG]…​`

* Add a student with the given details.
* The name and nusnet id must be provided. And nusnet id must be unique.
* All the remaining fields are optional. If not provided, a placeholder value will be used.

<box type="tip" seamless>

**Tip:** A person can have any number of tags (including 0)
</box>

Examples:
* `addstu n/John Doe nn/e1234567 p/98765432 e/johnd@example.com m/Computer Science`
* `addstu n/Betsy Crowe nn/e01234567 t/friend e/betsycrowe@example.com m/Mathematics p/1234567 t/club`
* `addstu n/Betsy Crowe nn/e01234567`

<markdown class="d-print-none">---</markdown>
<div style="page-break-after: always;"></div>
<br>

### <i class="fa-solid fa-list-ul"></i> Listing all students : `list`

Shows a list of all persons in the contact book.

Format: `list`

If there are additional arguments behind `list` we will simply ignore them.

<markdown class="d-print-none">---</markdown>
<div style="page-break-after: always;"></div>
<br>

### <i class="fa-solid fa-user-pen"></i> Editing a student : `edit`

Edits an existing person in the contact book.

Format: `edit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [m/MAJOR] [nn/NUSNET_ID] [t/TAG]…​`

* Edits the person at the specified `INDEX`. The index refers to the index number shown in the displayed person list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the person will be removed i.e adding of tags is not cumulative.
* You can remove all the person’s tags by typing `t/` without
    specifying any tags after it.

Examples:
*  `edit 1 p/91234567 e/johndoe@example.com` Edits the phone number and email contact of the 1st person to be `91234567` and `johndoe@example.com` respectively.
*  `edit 2 n/Betsy Crower t/` Edits the name of the 2nd person to be `Betsy Crower` and clears all existing tags.

<box type="info" seamless>
This command differs from most other commands that use the `NUSNET_ID` to identify a student. This command uses the index number shown in the displayed person list to identify the student to be edited.
</box>

<markdown class="d-print-none">---</markdown>
<div style="page-break-after: always;"></div>
<br>

### <i class="fa-solid fa-magnifying-glass"></i> Locating students by name: `find`

Finds students whose names contain any of the given keywords.

Format: `find KEYWORD [MORE_KEYWORDS]…​`

<box type="info" seamless>

**Parameters of `find` command:**

- `KEYWORD` is the first keyword to search for. This is a compulsory parameter.
- `[MORE_KEYWORDS]…​` are additional, optional keywords to search for. You can have any number of additional keywords.

</box>

<box type="info" seamless>

**About the `find` command:**

<box type="success" seamless>

<span class="semi-bold">Only the name is searched.</span>

<span class="semi-bold">#g#Example:##</span> `E01234567` will not match a student with NUSNet ID `E01234567`.
</box>

<box type="success" seamless>

<span class="semi-bold">The name search is case-insensitive.</span>

<span class="semi-bold">#g#Example:##</span> `hans` will match `Hans`
</box>


<box type="success" seamless>

<span class="semi-bold">The order of the keywords does not matter.</span>

<span class="semi-bold">#g#Example:##</span> `Hans Bo` will match `Bo Hans`
</box>

<box type="success" seamless>

<span class="semi-bold">Only full words will be matched.</span>

<span class="semi-bold">#g#Example:##</span> `Han` will not match `Hans`
</box>

<box type="success" seamless>

<span class="semi-bold">Students' name matching at least one keyword will be returned (i.e. `OR` search).</span>

<span class="semi-bold">#g#Example:##</span> `Hans Bo` will return `Hans Gruber`, `Bo Yang`
</box>
</box>

<box type="success" seamless>

**Examples of using the find command:**

<box type="success" seamless>

<span class="semi-bold">#g#Example:##</span> `find John` returns `john` and `John Doe`
</box>


<box type="success" seamless>

<span class="semi-bold">#g#Example:##</span> `find alex david` returns `Alex Yeoh`, `David Li`, as seen in the image below.

<img src="images/findAlexDavidResult.png" alt="result for 'find alex david" width="500px" class="rounded-image"/>
</box>
</box>

<markdown class="d-print-none">---</markdown>
<div style="page-break-after: always;"></div>
<br>

### <i class="fa-solid fa-square-check"></i> Marking a student's attendance for a given week by their NUSNet: `mark`

Marks a student's attendance for a particular week.

Format: `mark nn/NUSNET_ID wk/WEEK_NUMBER`

Example:
* `mark nn/e1234567 wk/3`

<markdown class="d-print-none">---</markdown>
<br>

### <i class="fa-solid fa-square-xmark"></i> Unmarking a student's attendance for a given week by their NUSNet: `unmark`

Unmarks a student's attendance for a particular week.

Format: `unmark nn/NUSNET_ID wk/WEEK_NUMBER`

Example:
* `unmark nn/e1234567 wk/3`

<markdown class="d-print-none">---</markdown>
<div style="page-break-after: always;"></div>
<br>

### <i class="fa-solid fa-trash"></i> Deleting a student: `delstu`

Deletes the specified student from the contact book.

Format: `delstu nn/NUSNET_ID`

* Deletes the student with the specified NUSNet ID from the contact book. 

Examples:
* `delstu nn/E0957499` deletes the student with the NUSNet ID of `E0957499` in the contact book.

Pro Tip:
* If you cannot remember your student's NUSNet ID, you could use `find Betsy` or `list` followed by `delstu nn/<Betsy's NUSNET_ID>` to find and delete the student.

<markdown class="d-print-none">---</markdown>
<div style="page-break-after: always;"></div>
<br>

### <i class="fa-solid fa-broom"></i> Clearing all entries : `clear`

Clears all entries from the contact book.

Format: `clear`

<markdown class="d-print-none">---</markdown>
<br>

### <i class="fa-solid fa-right-from-bracket"></i> Exiting the program : `exit`

Exits the program.

Format: `exit`

<markdown class="d-print-none">---</markdown>
<div style="page-break-after: always;"></div>
<br>

### <i class="fa-solid fa-wand-magic-sparkles"></i> Autocomplete

Autocompletes a word or a set of words, based on the current input.

<box type="warning" seamless>

**Autocomplete doesn't work on week number:**

This is because week number is short,
and it is much faster just typing out the number.

</box>

<box type="success" seamless>

<span class="semi-bold">#g#Example:##</span>

We have three students with NUSNet IDs `e0123456`, `e1234567` and `e2345678`. 
If we type `mark nn/` into the command input box and press <span class="badge bg-light text-dark">Tab</span>,
we can see that the text in the command input box autocompletes to become `mark nn/e01234567`.

Pressing <span class="badge bg-light text-dark">Tab</span> again, causes the text to update to `mark nn/e1234567`,
followed by `mark nn/e2345678`.
</box>

<box type="info" seamless>

**Using autocomplete to scroll through all possible autocomplete suggestions:**

Autocomplete will scroll through all possible options, based on the existing data in your contact list.

When reaching the end of the possible options list, pressing
<span class="badge bg-light text-dark">Tab</span> will wrap 
the possible options back to the start of that list again.
</box>

<box type="info" seamless>

**Sorted autocomplete suggestions:**

The autocomplete suggestions will be listed in alphabetical order, meaning if you have two possible options
`abc` and `abd`, autocomplete will give `abc` before `abd`.
</box>

<markdown class="d-print-none">---</markdown>
<div style="page-break-after: always;"></div>
<br>

### <i class="fa-solid fa-clock-rotate-left"></i> Retrieving command history

TAPro saves successful commands input, so you can retrieve them later, using the 
<span class="badge bg-light text-dark">Up</span> and
<span class="badge bg-light text-dark">Down</span> keys.

<box type="success" seamless>

<span class="semi-bold">#g#Example:##</span>

We have entered `mark nn/e0123456` as the previous command, and it was successful. Now the command input box is empty.

Pressing <span class="badge bg-light text-dark">Up</span> will update the text in the command input box to
the previous command `mark nn/e0123456`.
</box>

<box type="warning" seamless>

**Only successful commands will be retrieved:**

If you enter an invalid command, it will not appear when attempting to retrieve it.
</box>

<markdown class="d-print-none">---</markdown>
<div style="page-break-after: always;"></div>
<br>

### <i class="fa-solid fa-floppy-disk"></i> Saving the data

TAPro's data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

<markdown class="d-print-none">---</markdown>
<br>

### <i class="fa-solid fa-pen-to-square"></i> Editing the data file

TAPro's data are saved automatically as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

<box type="warning" seamless>

**Caution:**

If your changes to the data file makes its format invalid, TAPro will discard all data and start with an empty data file at the next run.  Hence, it is recommended to take a backup of the file before editing it.<br>

Furthermore, certain edits can cause the TAPro to behave in unexpected ways (e.g., if a value entered is outside the acceptable range). Therefore, edit the data file only if you are confident that you can update it correctly.
</box>

<markdown class="d-print-none">---</markdown>
<div style="page-break-after: always;"></div>
<br>

## <i class="fa-solid fa-comments"></i> FAQ

<box type="info" icon=":fa-solid-question:" seamless>

<i class="fa-regular fa-circle-question"></i>
**Q:** How do I transfer my data to another computer?

<i class="fa-regular fa-comment-dots"></i>
**A:** Install the application in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous TAPro home folder.
</box>



<markdown class="d-print-none">---</markdown>
<br>

## <i class="fa-solid fa-triangle-exclamation"></i> Known issues


<box type="warning" theme="danger" seamless>

**1. When using multiple screens**

If you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.
</box>

<markdown class="d-print-none">---</markdown>
<div style="page-break-after: always;"></div>
<br>

## <i class="fa-solid fa-table-list"></i> Command summary

| Action             | Format, Examples                                                                                                                                                                       |
|--------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Add Student**    | `addstu n/NAME p/PHONE_NUMBER e/EMAIL nn/NUSNET_ID m/MAJOR [t/TAG]…​` <br> e.g., `add n/James Ho p/22224444 e/jamesho@example.com nn/e1234567 m/Computer Science t/friend t/colleague` |
| **Clear**          | `clear`                                                                                                                                                                                |
| **Delete Student** | `delstu nn/NUSNET_ID`<br> e.g., `delstu nn/e0957499`                                                                                                                                   |
| **Edit**           | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [m/MAJOR] [t/TAG]…​`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com`                                                              |
| **Mark**           | `mark nn/NUSNET_ID wk/WEEK_NUMBER`<br> e.g., `mark nn/e1234567 wk/3`                                                                                                                   |
| **Unmark**         | `unmark nn/NUSNET_ID wk/WEEK_NUMBER`<br> e.g., `unmark nn/e1234567 wk/3`                                                                                                               |
| **Find**           | `find KEYWORD [MORE_KEYWORDS]…​`<br> e.g., `find James Jake`                                                                                                                           |
| **Set Course**     | `setcrs COURSE_NAME`                                                                                                                                                                   |
| **List**           | `list`                                                                                                                                                                                 |
| **Help**           | `help`                                                                                                                                                                                 |
| **Exit**           | `exit`                                                                                                                                                                                 |
