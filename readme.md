# Environment configuration. First steps
We start with simple maven archetype for quickstart and we need to configurate
certains things


- The JDK which we are going to use must be correctly confiurates.
- In the POM.xml is configurated Junit 4.11, but we are going to use 5.x
- Review warnings
- Create ignore file
- push to the repository a 0.1.0 version

## JDK

### To use the embedded JDK
In File->Project structure->Project:
SDK: selected 18 Oracle OpenJDK
Language level: SDK default
In File->Project structure->Modules
Language level. You need to change, for example 17 (for LTS). If you don’t change it you will have compilations problems with lambdas and another things.


### To use the computer JDK

We can configurate IntelliJ with the maven and JDK in your computer.
I prefer in this kata to test with the command line it.

Write in the root of the directory:

```
mvn clean test
```
If this is not working, you must review the configuration of JDK and Maven in your machine.
### Using the maven wrapper or a custom version of Maven

You could change it in your IDE. You have more information in:
https://www.jetbrains.com/help/idea/maven-support.html#maven2_install

## Junit 5.x configuration
https://www.baeldung.com/junit-5

I used to remove the AppTest class and after we change the pom.xml
In https://mvnrepository.com/ you can find the last version. For example:
<!-- https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api -->
``` xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.9.0-M1</version>
    <scope>test</scope>
</dependency>
```
I used to change the maven compiler source for 1.8. By default the value is 1.7.
That's mean you are using maven 1.8 which is compatible with JDK 1.8+

In addition, we need to update the Maven compiler and the maven surfire plugins to the last version.

After this, you need to reload the maven project with File->Maven->Reload project

At the end, I use a Dummy test and compile

```java
package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DummyTest {
    @Test
    public void itShouldBeTrue() {
        assertTrue(true);
    }
}
```
We go to run menu and create a configuration "maven" which do "clean test".
After this, we do the same but with junit choosing "all in package" to discover tests
y le damos a Run y metemos una configuración de tipo maven que haga "clean test"

## Review warnings

Review everything
NOTA: Con assertTrue nos puede salir con junit un problema respecto que +
## Create a ignore file
By default, IntelliJ creates a .gitignore file with all you need, but it would be interesting
to check it. 

Open the git console, set in the root folder of the project and write:
```
git status
```
 for example in my case, the changes are affected to the source and test files, but
also to some files in .idea, as for example: misc.xml and workspace.xml. 
We need to ignore them and the reason because they appeair is explained here:
 https://stackoverflow.com/questions/19973506/cannot-ignore-idea-workspace-xml-keeps-popping-up

Basicly you will have to close your IDE and execute the following sentences in git:
``` git 
mv .idea ../.idea_backup
rm .idea # in case you forgot to close your IDE
git rm -r .idea
git commit -m "Remove .idea from repo"
mv ../.idea_backup .idea
```
Now, you don`t more problems.
```
git status
git add *
git commit -m '0.1.0 - first version'
git status
```
# FizzBuzz Kata
Start with TDD and create a parametrized Test. The Kata is the following:
https://katalyst.codurance.com/fizzbuzz
## Introduction
This kata, taken from a popular children's maths game (or student drinking game), is the starting point on the TDD track. It's designed to be a semi-guided first stop for learning TDD from scratch.

We'll emphasise the following:

Start by writing a failing test for the simplest behaviour.
Implement the simplest amount of code needed to make the test pass.
As you add more tests, refactor to make the code more generic and more suitable.
## Instructions
Write a function that takes positive integers and outputs their string representation.

Your function should comply with the following additional rules:

If the number is a multiple of three, return the string "Fizz".
If the number is a multiple of five, return the string "Buzz".
If the number is a multiple of both three and five, return the string "FizzBuzz".
For example, given the numbers from 1 to 15 in order, the function would return:
```
1
2
Fizz
4
Buzz
Fizz
7
8
Fizz
Buzz
11
Fizz
13
14
FizzBuzz
```

# During the Kata...
## Parametrized Tests could be interesting
You can read this article: https://www.baeldung.com/parameterized-tests-junit-5

Basically you need to include in the POM:
``` xml
<!-- https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-params -->
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-params</artifactId>
    <version>5.9.0-M1</version>
    <scope>test</scope>
</dependency>

```
Review always the version in:
https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-params
