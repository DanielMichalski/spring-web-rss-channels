Spring Web RSS Channels
---------------------------------------------

Spring Web RSS Channels is a RSS feed reader web application built on Spring, JPA (Hibernate), Twitter Bootstrap, Apache tiles and JQuery. \
It allows you to specify RSS channels and then display results.

[![Spring Web RSS Channels](https://github.com/DanielMichalski/spring-web-rss-channels/blob/master/.github/gifs/application.gif)](https://youtu.be/5v8eZnM4ojU "Spring Web RSS Channels")

[![Build Status](https://github.com/DanielMichalski/spring-web-rss-channels/workflows/Java%20CI%20with%20Maven/badge.svg?branch=master)](https://github.com/DanielMichalski/spring-web-rss-channels/actions?query=workflow%3A%22Java+CI+with+Maven%22)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://github.com/DanielMichalski/spring-web-rss-channels/blob/master/LICENSE)

## Documentation
The documentation is divided into several sections:
* [Prerequisites](#prerequisites)
* [Libraries](#libraries)
* [Running the application](#running-the-application)
    * [On Windows](#on-windows)
    * [On MacOS/ Linux](#on-macos-linux)
* [Application user](#application-user)
* [Video](#video)
* [Screens](#screens)

## Prerequisites
- [Java JDK 8](https://www.oracle.com/pl/java/technologies/javase/javase-jdk8-downloads.html)

## Libraries
| Library name                                        | Description                                                                                                                                                         |
|-----------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [Spring](https://spring.io/)                        | Spring makes programming Java quicker, easier, and safer for everybody.                                                                                             |
| [JPA (Hibernate)](https://hibernate.org/)           | Hibernate ORM enables developers to more easily write applications whose data outlives the application process.                                                     |
| [Twitter Bootstrap](https://getbootstrap.com/)      | Quickly design and customize responsive mobile-first sites with Bootstrap.                                                                                          |
| [Apache Tiles](https://tiles.apache.org/)           | A free open-sourced templating framework for modern Java applications. Based upon the Composite pattern it is built to simplify the development of user interfaces. |
| [jQuery + Ajax](https://jquery.com/)                | jQuery is a fast, small, and feature-rich JavaScript library. It makes things like HTML document traversal and manipulation, event handling and animation.          |
| [JQuery validator](https://jqueryvalidation.org/)   |  Validate forms like you've never validated before!                                                                                                                 |
| [Java Mail API](https://javaee.github.io/javamail/) | The JavaMail API provides a platform-independent and protocol-independent framework to build mail and messaging applications.                                       |

## Running the application
#### On Windows
```bash
## Build application from base directory using Maven Wrapper
mvnw.cmd clean install

## Run tomcat7 server and deploy the application
mvnw.cmd tomcat7:run-war -pl rss-web

## Application should be accessible at
http://localhost:8081/rss-web/
```

#### On MacOS/ Linux
```bash
## Build application from base directory using Maven Wrapper
./mvnw clean install

## Run tomcat7 server and deploy the application
./mvnw tomcat7:run-war -pl rss-web

## Application should be accessible at
http://localhost:8081/rss-web/
```

## Application user
```
login: admin
password: secret
```

## Video presentation
[![Spring Web RSS Channels](http://img.youtube.com/vi/5v8eZnM4ojU/0.jpg)](https://youtu.be/5v8eZnM4ojU "Spring Web RSS Channels")

## Screenshots
![alt text](https://github.com/DanielMichalski/spring-web-rss-channels/blob/master/rss-web/src/main/resources/img/screen1.png "Screen 1")

![alt text](https://github.com/DanielMichalski/spring-web-rss-channels/blob/master/rss-web/src/main/resources/img/screen2.png "Screen 2")

![alt text](https://github.com/DanielMichalski/spring-web-rss-channels/blob/master/rss-web/src/main/resources/img/screen3.png "Screen 3")

![alt text](https://github.com/DanielMichalski/spring-web-rss-channels/blob/master/rss-web/src/main/resources/img/screen4.png "Screen 4")

![alt text](https://github.com/DanielMichalski/spring-web-rss-channels/blob/master/rss-web/src/main/resources/img/screen5.png "Screen 5")

![alt text](https://github.com/DanielMichalski/spring-web-rss-channels/blob/master/rss-web/src/main/resources/img/screen6.png "Screen 6")
