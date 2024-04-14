---
layout: default.md
title: "Titus' Project Portfolio Page"
---
{% import "_markbind/_macros.nj" as macros %}

### Project: TAPro

**TAPro** is **a Contact Book application** that is made for Computer Science tutors for managing their students contact and attendance details.<br>

Given below are my contributions to the project.

* **New Feature**: Added the ability for syntax highlighting of messages in the result message panel. ([\#98](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/98), [\#122](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/122))
  * {{ macros.semiBold('What it does:') }} Allows the user to visually see more easily various keywords in the result message.<br><br>
  * {{ macros.semiBold('Justification:') }} This feature improves the efficiency of the user significantly, as it improves readability of the text in the result message panel, thus saving time. Moreover, as interacting with the result message panel is the main method a user knows whether a command is successful or unsuccessful, it can greatly improve a user's efficiency.<br><br>
  * {{ macros.semiBold('Highlights:') }} This feature is extensible and can be added on to future text features in the UI. Moreover, the syntax highlighting can be customized further without modifying the existing code significantly.<br><br>
  * {{ macros.semiBold('Credits:') }} The idea of syntax highlighting came from the syntax highlighting of common code editors and integrated development environments.<br><br>

* **New Feature**: Improved the autocomplete feature that was initially added by [Xiaoyun](http://github.com/ForAeons). ([\#131](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/131), [\#152](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/152), [\#225](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/225), [\#278](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/278))
  * {{ macros.semiBold('What it does:') }} Added circular TAB scrolling for autocomplete. Also added autocomplete for the rest of the fields, except for week number. <br><br>
  * {{ macros.semiBold('Justification:') }} By improving autocomplete, it improves the efficiency of users, and makes our autocomplete feature more complete.<br><br>
  *   {{ macros.semiBold('Highlights:') }} Autocomplete works with all commands, and most parameters, and works in an extensible way. It is also optimized for performance through caching and lazy evaluation. It uses a new package that manages Tries with attributes and notifying and updating changes from the data using an observer-like design pattern.<br><br>
  * {{ macros.semiBold('Credits:') }} The idea of autocompletion came from how many common command terminals had autocomplete as a feature, and I wanted to replicate its behaviour in TAPro.<br><br>

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2324s2.github.io/tp-dashboard/?search=tituschewxj&breakdown=true&sort=groupTitle%20dsc&sortWithin=title&since=2024-02-23&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other)

* **Project management**:
  * Managed releases `v1.2`, `v1.2b`, `v1.3`, `v1.3b` on GitHub <br><br>

* **Enhancements to existing features**:
  * Improved the text wrapping in the result message panel, which improves the efficiency in which the user interacts with our interface, as no more scrolling is required to view the full result message. ([\#98](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/98))
  * Improved the help window, which allowed for quick reference to commands. ([\#41](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/41), [\#124](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/124), [\#136](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/136))
  * Added helper classes for message usage, which greatly improved consistency between different messages. ([/#35](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/35), [\#61](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/61))<br><br>

* **Documentation**:
    * {{ macros.semiBold('User Guide:') }}
      * Improved the formatting for the user guide ([\#134](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/134), [\#262](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/262), [\#291](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/291))
      * Various fixes to documentation ([\#227](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/227/files), [\#229](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/229))
      * Updated the documentation for autocomplete ([\#261](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/261))
      * Various other documentation improvements ([\#279](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/279), [\#280](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/280), [\#281](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/281))<br><br>
    * {{ macros.semiBold('Developer Guide:') }}
      * Improved the formatting of the developer guide ([\#239](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/239))
      * Added the design decisions ([\#285](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/285)) 
      * Added the planned enhancements ([\#295](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/295))<br><br>
    * {{ macros.semiBold('Miscellaneous:') }}
      * Added semi-bold font
      * Added custom question and command format callouts
      * Integrated Nunjucks variables and macros to the project ([\#239](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/239), [\#291](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/291))<br><br>

{{ newPageBetween }}

* **Community**:
  * PRs reviewed (with non-trivial review comments): [\#9](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/9), [\#21](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/21), [\#52](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/52), [\#53](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/53), [\#62](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/62), [\#71](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/71), [\#82](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/82), [\#112](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/112), [\#130](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/130), [\#232](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/232), [\#258](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/258), [\#264](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/264), [\#270](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/270), [\#271](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/271), [\#286](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/286), [\#289](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/289)
  * Contributed to forum discussions (examples: [\#122](https://github.com/nus-cs2103-AY2324S2/forum/issues/122), [\#242](https://github.com/nus-cs2103-AY2324S2/forum/issues/242))
  * Reported bugs and suggestions for other teams in the class (examples: [PE-D](https://github.com/tituschewxj/ped/issues))<br><br>

* **Tools**:
  * Integrated MarkBind as a dev-dependency to the project ([\#80](https://github.com/AY2324S2-CS2103T-F13-1/tp/pull/80))
