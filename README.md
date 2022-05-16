# Software engineering basics - my implimentation of a course "Basics of software engineering" at ITMO University, 2nd year

## Course description
There are 4 labs to complete in this course. It is planned to publish all 4 solved laboratory works, 
as well as my lecture notes, made on the basis of the lecture material I listened to. Also t's planned transliate all published matherials to English.

## Lab work #1 — variant 1413
**Task:**

Make a list of requirements for the developed website (according to the option). Requirements should fall into the following categories:

Functional requirements (site user requirements & requirements of site owners) and non-functional requirements;

Requirements must be formatted in accordance with RUP templates (SRS - Software Requirements Specification document). 
For each of the requirements, you need to specify its attributes (in accordance with the RUP methodology), 
as well as estimate and argue the approximate number of hours required to implement this requirement.
For functional requirements, you need to create UML UseCase diagrams that describe the use cases that implement them.

**The lab report should contain:**

1. A Software Requirements Specification document containing a list of site requirements.
2. UseCase diagrams of use cases that implement functional requirements.
3. Work conclusions.

## Lab work #2 — variant 1422
**Task:**

Configure the svn and git repositories in your home directory and upload [the initial revision of the source files](https://github.com/nesterrovv/software-engineering-basics/blob/master/images/lab2-schema-revesion.png) to them (according to the given option).
Reproduce the sequence of commands for the svn and git version control systems that perform the operations on the source code shown in the flowchart.
When composing a sequence of commands, the following conditions must be taken into account:

1. The color of the elements of the scheme indicates the user who performed the action (red - the first, blue - the second).
2. The numbers above the nodes are the revision number. Revisions are created sequentially.
3. You must resolve conflicts between versions if they arise.

**The lab report should contain:**

1. Task and flowchart in accordance with the option.
2. List of commands used to create and configure repositories in the user's home directory.
3. Revision numbers and corresponding command sequences with comments (for svn and git).
4. Work conclusions.

## Lab work #3 — variant 1423
**Task:**

Write a script for the [Apache Ant](https://ant.apache.org/) utility that implements compilation, testing, and packaging into a jar-archive of the project 
code from [laboratory work #5](https://github.com/nesterrovv/Programming/tree/main/Lab5) in the "Programming" discipline.

My assignment is slightly different from the options given by my classmates due to the fact that [laboratory work #3](http://se.ifmo.ru/courses/web#labs)  in the "Web Programming" discipline (which everyone is invited to test) is not yet ready for me, since I recently transferred to this faculty and have not yet managed to pass the necessary laboratory work. However, according to the teacher, you can do the task on any program with some kind of interactive, so I will do it on the specified one.

Each stage should be separated into a separate script block; all variables and constants used in the script must be placed in 
a separate parameter file; MANIFEST.MF should contain information about the version and about the class being started.

**The script must implement the following targets:**

1. **compile** — compilation of project source codes.
2. **build** — Compiling project sources and packing them into an executable jar. Compilation of source codes is implemented by calling the compile target.
3. **clean** — remove compiled project classes and all temporary files (if any).
4. **test** — run the project's junit tests. Before running the tests, you need to build the project (build target).
5. **xml** — validation of all xml files in the project.
6. **report** — in case of successful tests, saves the junit report in xml format, adds it to the git repository and commits.
