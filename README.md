# KOTLIN CLEAN ARCHITECTURE - LIBRARY MANAGER

This is a sample application and basic code that uses the Uncle Bob's clean architecture approach with **KOTLIN**.
This command line application allows you to manage a library of books.

## TECHNOLOGY STACK
COMPONENT                           | TECHNOLOGY              | FOR MORE INFORMATION
---                                 | ---                     |---
Languages & Frameworks              |`kotlin`                 | https://kotlinlang.org/
Libraries                           |`googlegson`             | https://github.com/google/gson
Gradle Plugin                       |`shadow`                 | https://imperceptiblethoughts.com/shadow/ 

## CLEAN ARCHITECTURE
The clean architecture is a software design philosophy that separates the elements of a design into circular levels. The main rule of clean architecture is that code dependencies can only come from the outer levels inward. The code of the inner layers cannot have any knowledge of the functions of the outer layers. Variables, functions and classes existing in the outer layers cannot be mentioned in the more inner levels.

Each of these architectures produces systems that are :
- Independent of any Framework: (the architecture does not depend on the existence of any software library loaded with functionalities)
- Testable: (business rules can be tested without the user interface, database, web server or any other external component)
- Independent of the user interface: (a web user interface can be replaced by a console user interface without modifying the rest of the system)
- Independent of any database: (you can replace Oracle or SQL Server by Mongo, BigTable, CouchDB or other)
- Independent of any external agency : (your business rules know nothing at all about the outside world)

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

## PROJECT STRUCTURE
```
|   .gitignore
|   build.gradle.kts (similiar to build.gradle - but with Kotlin DSL)
|   gradle.properties
|   gradlew (shell script to execute the build with the wrapper)
|   gradlew.bat (widows batch script to execute the build with the wrapper)
|   library.json (JSON file used to export the library)
|   local.properties
|   README.md
|   settings.gradle.kts
|
+---diagrams (contains all diagrams related to this project)
+---gradle
|   +---wrapper (script that invokes a declared version of gradle - to run a gradle project without having to go through a manual installation process)
|           gradle-wrapper.jar (JAR file which contains the code for downloading the gradle distribution)
|           gradle-wrapper.properties (properties file responsible for configuring the behavior of the wrapper runtime)
|
+---src
    +---main
        +---kotlin
            +---entities (contains business objects)
            |       Book.kt
            |       Library.kt
            |
            +---external (contains an interface to export library books)
            |       Export.kt
            |
            +---usecases (contains business usecases)
            |       Management.kt
            |
            +---userinterface (contains a command line user interface)
                    Application.kt
```

## GETTING STARTED
Clone the application, run the following command:
```
git clone https://github.com/Nakebenihime/library-manager.git
```

In order to build our application in an all-in-one **JAR** in Gradle using the Kotlin DSL (with a build.gradle.kts instead of build.gradle), we use the Shadow Gradle plugin.
For more instructions about this plugin, visit [imperceptiblethoughts.com](https://imperceptiblethoughts.com/shadow/) official website.

I added the following lines in build.gradle.kts:
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

Build the application:
```
gradlew shadowJar
```

Run the application:
```
java -jar build/libs/library-manager-1.0-SNAPSHOT-all.jar
```

## EXPLORE THE APPLICATION
Once the JAR is launched, a menu is displayed with different actions to manage your library:
```
Welcome to your library:
press '1' to add a book
press '2' to list all books
press '3' to delete a book with UUID
press '4' to count the books in the library
press '5' to export the library
```
