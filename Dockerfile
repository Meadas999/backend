FROM openjdk:17-jdk-alpine
MAINTAINER Amier
COPY target/AppBack-0.0.1-SNAPSHOT.jar AppBack-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/AppBack-0.0.1-SNAPSHOT.jar"]