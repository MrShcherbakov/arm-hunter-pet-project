FROM eclipse-temurin:17-jre-jammy
WORKDIR /app/core-api
EXPOSE 8081
COPY target/*.jar /app/core-api/*.jar
ENTRYPOINT [ "java", "-jar", "/app/core-api/*.jar" ]