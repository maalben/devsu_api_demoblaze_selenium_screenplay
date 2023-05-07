# devsu_api_demoblaze_selenium_screenplay

# How execute project

## Use Gradle

Open a command window and run:

MacOs:
./gradlew test
./gradlew test -Denv=qa

Windows:
gradlew test
gradlew test -Denv=qa

## Running tests by tags, be aware of the Operating System

    ./gradlew clean test -Dtags='<TAG>' -Denv=qa

## Viewing the reports

Both of the commands provided above will produce a Serenity test report in the `target/site/serenity` directory. Go take a look!

