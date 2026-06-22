# Object-Oriented Programming (JAVA)

This repository is a complete Java OOP course practice and project repository for **American International University-Bangladesh (AIUB)**. It is designed as a professional GitHub submission with Maven modules, GitHub Actions CI, package naming under `bd.edu.aiub.oop`, and practical exam-style solutions.

## What This Repository Covers

|  OOP | Evidence in Repository |
|---|---|
| Basics and Memory | primitives vs references, `Scanner` validation, command-line arguments, 1D/2D arrays, matrix operations |
| Encapsulation | private fields, validated setters/getters, constructor overloading, `this()` chaining |
| Inheritance | `Person -> Employee -> Faculty`, `extends`, explicit `super()` calls |
| Polymorphism | method overloading, method overriding, `@Override`, dynamic dispatch |
| Abstraction | abstract classes, interfaces, multiple interface implementation |
| Static and Final | class-level counters/utilities, constants, final classes, final methods |
| Exceptions | custom checked exceptions, `throw`, `throws`, `try-catch-finally` |
| File I/O | `BufferedReader`, `BufferedWriter`, CSV save/load |
| Collections | `ArrayList`, `HashMap`, defensive copies, search operations |
| Project | modular console Student Information System with persistent data |

## Structure

```text
.github/workflows/maven.yml
01-lab-tasks/
02-assignments/
03-past-exams/
04-course-project/
pom.xml
README.md
```

## Build

```bash
mvn clean package
```

If Maven is unavailable:

```bash
./build-with-javac.sh
```

## Run Examples

```bash
javac -d out $(find . -name "*.java")
java -cp out bd.edu.aiub.oop.lab01.BasicsMemoryLab
java -cp out bd.edu.aiub.oop.assignment.midterm.BankAssignmentApp
java -cp out bd.edu.aiub.oop.courseproject.Main
```

## Grading Matrix

| Requirement | Included |
|---|---|
| Correct syntax | All source files are compile-ready |
| Private attributes | Used across all domain classes |
| Constructor overloading | Lab 02 and multiple project models |
| `this()` and `super()` | Lab 02 and Lab 03 |
| Overloading/overriding | Lab 04 and project services |
| Abstract/interface | Lab 05 and course project contracts |
| `static` and `final` | Lab 06 and project constants |
| Custom exception handling | Lab 07, assignments, final project |
| File persistence | Lab 08 and final project |
| Professional layout | Maven multi-module architecture and CI |

## Viva Answer Strategy

For every topic, explain: what the class represents, why attributes are private, what validation prevents, which OOP pillar is used, and how the data flows from model to service to repository.
