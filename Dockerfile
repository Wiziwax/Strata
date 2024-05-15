FROM openjdk:17
#RUN mkdir /app
#RUN mkdir /app/lib
WORKDIR /opt
COPY target/*.jar /opt/app.jar
#COPY src/main/resources/application.yml /app/application.yml
#COPY path/to/mysql-connector-java.jar /app/lib/mysql-connector-java.jar
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar
#ENTRYPOINT ["java", "-jar", "/app/strata-api.jar"]