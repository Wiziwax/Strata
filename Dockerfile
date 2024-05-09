FROM openjdk:17
ADD target/strata-api.jar strata-api.jar
#ARG JAR_FILE=target/*.jar
#COPY ./target/Strata-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/strata-api.jar"]