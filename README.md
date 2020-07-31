Spring Web RSS Channels
---------------------------------------------
This project aims to present how to create a Spring MVC + JPA/Hibernate Web application.

Libraries
---------------------------------------------
- Spring Security and Data Repositories
- JPA (Hibernate)
- Twitter Bootstrap
- Apache Tiles
- JQuery + Ajax
- JQuery validator
- Java Mail API

Requirements
---------------------------------------------
- [Java JDK 8](https://www.oracle.com/pl/java/technologies/javase/javase-jdk8-downloads.html)

How to run application
---------------------------------------------
On Windows
```bash
## Build application from base directory using Maven Wrapper
mvnw.cmd clean install

## Run tomcat7 server and deploy the application
mvnw.cmd tomcat7:run-war -pl rss-web

## Application should be accessible at
http://localhost:8081/rss-web/
```

On MacOS/ Linux
```bash
## Build application from base directory using Maven Wrapper
./mvnw clean install

## Run tomcat7 server and deploy the application
./mvnw tomcat7:run-war -pl rss-web

## Application should be accessible at
http://localhost:8081/rss-web/
```

Application user
---------------
```
login: admin
password: secret
```

Video
-----

[![Spring Web RSS Channels](http://img.youtube.com/vi/5v8eZnM4ojU/0.jpg)](https://youtu.be/5v8eZnM4ojU "Spring Web RSS Channels")

Screens
---------------------------------------------

![alt text](https://github.com/DanielMichalski/spring-web-rss-channels/blob/master/rss-web/src/main/resources/img/screen1.png "Screen 1")

![alt text](https://github.com/DanielMichalski/spring-web-rss-channels/blob/master/rss-web/src/main/resources/img/screen2.png "Screen 2")

![alt text](https://github.com/DanielMichalski/spring-web-rss-channels/blob/master/rss-web/src/main/resources/img/screen3.png "Screen 3")

![alt text](https://github.com/DanielMichalski/spring-web-rss-channels/blob/master/rss-web/src/main/resources/img/screen4.png "Screen 4")

![alt text](https://github.com/DanielMichalski/spring-web-rss-channels/blob/master/rss-web/src/main/resources/img/screen5.png "Screen 5")

![alt text](https://github.com/DanielMichalski/spring-web-rss-channels/blob/master/rss-web/src/main/resources/img/screen6.png "Screen 6")
