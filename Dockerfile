FROM openjdk:8-jdk-alpine
LABEL responsable="o.barberis@outlook.fr"
EXPOSE 8049:8080
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} note.jar
ENTRYPOINT ["java","-jar","/note.jar"]