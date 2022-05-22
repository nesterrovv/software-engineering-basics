# Lab work #3. Software testing. Assembly systems.
## Variant: 1423

**Task:**

Write a script for the [Apache Ant](https://ant.apache.org/) utility that implements compilation, testing, and packaging into a jar-archive of the project 
code from [laboratory work #2](https://github.com/nesterrovv/web-programming/lab2) in the "Web-programming" discipline.

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

**Questions for the defense of laboratory work:**

1. Software testing. Purpose of testing, types of testing.
2. Unit testing, basic principles and approaches used.
3. JUnit package, core APIs.
4. Automatic assembly systems. Purpose, principles of operation, examples of systems.
5. Make utility. Makefiles, targets and rules.
6. Ant utility. Build scripts, targets and commands.
