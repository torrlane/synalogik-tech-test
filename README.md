# Synalogik tech test

# Thoughts on failing the test
This is my solution to the coding test. Sadly, it wasn't good enough to get me past the coding test part of the interview process. Here are some ideas of things that I could have done better:

* Thought harder and gave more justification for my criteria for what constitutes a word. In my solution I use a relatively simple regex to split the text into words. I should have added some javadoc or markdown in the README to explain and justify that criteria.
* Contact the recruiter or HR person to ask for more requirements around what constitutes a word. It might have been a test of initiative - this would have shown them that I have it.

From searching github, the following solutions appear to be reasonably good:

* https://github.com/torrlane/WordCountSynalogik
* https://github.com/torrlane/SYNALOGiKJavaProgrammingTest
* https://github.com/torrlane/word-length-frequency

I have noticed that they contain considerably more documentation than my submission - either through code comments / javadoc or in the README. 

If anyone from Synalogik ever sees this, please feel free to reach out to me to let me know how I could have improved my solution. 

# How to build and run the code

It has been tested using openjdk17 and maven 3.6.3 on windows 10.

Build:

```shell
mvn package
```

Run:

```shell
mvn exec:java -Dexec.mainClass="com.synalogik.Main" -Dexec.arguments=path_to_my_file
```

Alternatively, if you want to run it as a standalone jar:

```shell
cd target
java -jar text-stats-1.0-SNAPSHOT.jar path_to_my_file
```

See the `com.synalogik.Main` class for criteria for deciding whether a piece of text is considered to be a word
