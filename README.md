# Synalogik tech test

This is my solution to the coding test. Sadly, it wasn't good enough to get me past the coding test part of the interview process. I have absolutely no idea what is wrong with it. However, to improve, you might want to consider thinking about what constitutes a word. In my solution I use a relatively simple regex to split the text into words. However, that's clearly not sufficient. If possible, you should try to contact the recruiter or HR person to ask for more requirements around what constitutes a word. Similarly, try to think yourself about what should be considered a word. This might entail writing your own implementation of the scanner in the Main class. 

I should have also included more details on what a word is considered to be based on the example text in the question. 

With Regards to efficiency, I think that this solution should be pretty good. However, there might be opportunities to improve it that I haven't considered.

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
