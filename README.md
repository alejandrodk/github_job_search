# Github Job Search
## _Command line app to find jobs_

Github job search is a command line app develop in Java 8 using Functional Programming concepts.
this app use the github jobs api to find, filter and get jobs.
[Github jobs Api](https://jobs.github.com)

## Tech stack
- Java 8 SE
- Git

## Dependencies

| Plugin | Description |
| ------ | ------ |
| Gradle | Project management |
| Lombok | Avoid repetitive code |
| JCommander | Parse command prompt data to Java object |
| Feign | Make HTTP Requests |
| Feign Gson | Parse JSON responses to Java Object using Gson |

## Installation and usage
```sh
cd JavaSE-Functional-JobSearch-project
./gradlew build
```
Unzip ZIP file located in
/build/distributions
```sh
cd JavaSE-Functional-JobSearch-project-0.1.0
cd bin
# Execute app
./JavaSE-Functional-JobSearch-project [job keyword] arguments...
```
example
```sh
# Find full-time jobs for React developers in Berlin
./JavaSE-Functional-JobSearch-project React --full-time --min -l Berlin
```
expected result
```sh
title: Senior Full Stack Software Engineer (Frontend & Backend) in Typescript / Javascript
company: Kausa
location: Berlin
type: Full Time
+-----------------------------+

title: Senior JavaScript Developer (f/m/x)
company: Kontist GmbH
location: Berlin
type: Full Time
+-----------------------------+

```

## CLI arguments flags
| flag | description | default |
| ------ | ------ | -- |
| --full-time | only get full time jobs | false
| --location, -l | filter by location |
| --page, -p | results page (50 results per page)| 0
| --markdown | print results in markdown format | false
| --min | print results with short description | false
| --help | show CLI guide

