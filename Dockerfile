FROM maven:3.5.4-jdk-8-alpine as build 
WORKDIR /app
COPY  src /app/src
COPY pom.xml /app 
RUN mvn clean package

FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=build /app/target/myapp.jar /app
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/myapp.jar"]
