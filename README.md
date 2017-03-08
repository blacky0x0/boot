#### Default Project Structure
See: 14.2 Locating the main application class -> http://docs.spring.io/spring-boot/docs/1.5.2.RELEASE/reference/htmlsingle/#using-boot-locating-the-main-class

#### Local Development & Starting an Application
See: 66.2 Packaging executable jar and war files -> http://docs.spring.io/spring-boot/docs/1.5.2.RELEASE/reference/htmlsingle/#build-tool-plugins-maven-packaging

#### Start a Spring Boot Application
```
mvn clean package spring-boot:run

## or to run with specified profile
mvn clean package spring-boot:run -Dspring.profiles.active=local

## or to run as executable JAR with debug info
mvn clean package
java -jar target/boot.jar --spring.profiles.active=local --debug
```