# textstats

This is my solution to the coding test. It has been tested using openjdk17 and maven 3.6.3 on windows 10.

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

See the `com.synalogik.Main` class for criteria for deciding what text is considered to be a word
