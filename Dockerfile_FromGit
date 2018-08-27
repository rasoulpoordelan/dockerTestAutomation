FROM alpine/git as clone 
WORKDIR /app
RUN git clone https://github.com/rasoulpoordelan/dockerTestAutomation.git
FROM maven:3.5.4-jdk-8-alpine as build 
WORKDIR /app
COPY --from=clone /app/dockerTestAutomation /app 
RUN mvn clean package
FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=build /app/target/myapp.jar /app
CMD ["java -jar myapp.jar"
