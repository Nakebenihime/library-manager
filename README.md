# CLEAN ARCHITECTURE - LIBRARY MANAGER

This repository contains a project that shows an example of clean architecture using **KOTLIN**.
This command line application allows to manage a library of books.

## TECHNOLOGY STACK
COMPONENT                           | TECHNOLOGY              | FOR MORE INFORMATION
---                                 | ---                     |---
Languages & Frameworks              |`kotlin`                 | https://kotlinlang.org/
Libraries                           |`GoogleGson`             | https://github.com/google/gson
Gradle Plugin                       |`Shadow`                 | https://imperceptiblethoughts.com/shadow/ 

## CLEAN ARCHITECTURE
I think it's always good to start with some visualization :

![clean architecture](https://camo.githubusercontent.com/f5413c8722eb92d243d73932df3b3bdfd0bd4bf2/68747470733a2f2f3874686c696768742e636f6d2f626c6f672f6173736574732f706f7374732f323031322d30382d31332d7468652d636c65616e2d6172636869746563747572652f436c65616e4172636869746563747572652d386431666530363665386637666139633764386538346331613662306532623734623263363730666638303532383238663461376537336663626263363938632e6a7067)

The clean architecture is a software design philosophy that separates the elements of a design into circular levels. The main rule of clean architecture is that code dependencies can only come from the outer levels inward. The code of the inner layers cannot have any knowledge of the functions of the outer layers. Existing variables, functions and classes in the external layers cannot be mentioned in the more internal levels.

Each of these architectures produces systems that are :
- Independent of any Framework: (the architecture does not depend on the existence of any software library loaded with features)
- Testable: (business rules can be tested without the user interface, database, web server or any other external component)
- Independent of the user interface: (a web user interface can be replaced by a console user interface without  changing the rest of the system)
- Independent of any database: (you can replace Oracle or SQL Server with Mongo, BigTable, CouchDB, or anything else, your management rules are not linked to the database)
- Independent of any external agency: (your business rules don't know anything about the outside world at all)


### THE CONCEPT PRESENTED IN BULLET POINTS
**ENTITIES**
- represent your business objectives
- apply only the logic that is generally applicable to the entire entity (e.g. format validation)
- most stable code in your application (core business objects should almost never change)

**USE CASES**
- represent your business actions (what can you do in the application)
- pure business logic
- use cases do not know who triggered the action and how the results will be presented to the user

**INTERFACES/ADAPTERS**
- contain adapters to peripheral technologies
- implement the interfaces defined by the use cases

**EXTERNAL INTERFACES**
- contain tools such as databases or user-interfaces or frameworks...

## PREREQUISITES
These instructions will allow you to get a copy of the project on your **windows** machine, you must have the following software correctly installed in order to build the project.

### INSTALL JAVA
1. visit [oracle.com](https://www.oracle.com/java/technologies/javase-jdk14-downloads.html) official website
2. select the windows x64 installer
3. run the installer and follow the steps

Set a new "JAVA_HOME" variable under "advanced system settings" > "environment variables" and click "new system variable": 
```
variable name: JAVA_HOME
variable value: C:\Program Files\Java\jdk-14.0.2
```
In system variables, find PATH, click edit... button and add:
```
%JAVA_HOME%\bin
```
Open a command prompt window to verify the installation with the following command:
```
C:\Windows\System32> echo %JAVA_HOME%
C:\Program Files\Java\jdk-14.0.2

C:\Windows\System32> java -version
java version "14.0.2" 2020-07-14
Java(TM) SE Runtime Environment (build 14.0.2+12-46)
Java HotSpot(TM) 64-Bit Server VM (build 14.0.2+12-46, mixed mode, sharing)
```
## GETTING STARTED
clone the application, run the following command:
```
git clone https://github.com/Nakebenihime/angular-springboot-project.git
```

In order to build our application in an all-in-one **JAR** in Gradle using the Kotlin DSL (with a build.gradle.kts instead of build.gradle), we use the Shadow Gradle plugin.
For more instructions about this plugin, visit [imperceptiblethoughts.com](https://imperceptiblethoughts.com/shadow/) official website.

I added the following lines in build.gradle.kts) :
```
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
...    

plugins {
        id("com.github.johnrengelman.shadow") version "6.0.0"
}
...

tasks.withType<ShadowJar>() {
    manifest {
        attributes["Main-Class"] = "userinterface.ApplicationKt"
    }
}
```

build the application, using the following command:
```
gradlew shadowJar
```

run the application, using the following command:
```
java -jar build/libs/LibraryManager-1.0-SNAPSHOT-all.jar
```

## EXPLORE THE APPLICATION
Once the JAR is running, a menu will be displayed with different actions to manage your library:
```
Welcome to your library:
press '1' to add a book
press '2' to list all books
press '3' to delete a book with UUID
press '4' to count the books in the library
press '5' to export the library
```
