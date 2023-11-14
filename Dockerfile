FROM maven:3.9.5-amazoncorretto-8 as build
WORKDIR /projeto-gerenciamento-autocom
COPY . .
RUN mvn clean package -X -DskipTests

FROM openjdk:8-jdk-slim
WORKDIR /projeto-gerenciamento-autocom
COPY --from=build ./projeto-gerenciamento-autocom/target/*.jar ./autocom.jar
ENTRYPOINT java -jar autocom.jar
