# Lab work #4. Program profiling and monitoring. Java managment extensions. JConsole and VisualVM utilities. MBeans.
## Variant: 1439

**Task:**

**1. For your program from [laboratory work #2](https://github.com/nesterrovv/web-programming/lab2) in the discipline "Web-programming", implement:**

* An MBean that counts the total number of points set by the user, as well as the number of points that are out of scope. In case the user made 3 "misses" in a row, the designed MBean should send a notification about this event.
* An MBean that defines the average interval between user clicks on the coordinate plane.

**2. Use the JConsole utility to monitor the program:**

* Take readings of the MBean classes developed during task 1.

* Determine the names of all threads that run when the program starts.

**3. Use the VisualVM utility to monitor and profile the program:**

* Plot the MBeans developed in Task 1 over time.
* Determine the name of the class whose objects occupy the largest amount of JVM memory; define a custom class in which instances these objects reside.

**4. Use the VisualVM utility and the NetBeans IDE, Eclipse, or Idea profiler to isolate and fix performance issues in the program. Based on the results of localization and elimination of the problem, it is necessary to draw up a report, which should contain the following information:**

* Description of the identified problem.
* Description of ways to eliminate the identified problem.
* A detailed (with screenshots) description of the algorithm of actions that made it possible to identify and localize the problem.

The student must ensure that the process of searching and locating the problem can be reproduced at the request of the teacher.

**Questions for the defense of laboratory work:**
1. Monitoring and profiling. Basic concepts. Differences between monitoring and profiling.
2. Infrastructure for organizing monitoring and profiling as part of the JDK. JMX.
3. MBeans. Basic concepts. Framework architecture.
4. JConsole utility. Opportunities, scope.
5. Visual VM utility. Opportunities, scope.
6. Remote monitoring and profiling of applications on the Java platform.
