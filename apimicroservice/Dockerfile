FROM eclipse-temurin:17-jre-jammy
WORKDIR /app/apimicroservice
EXPOSE 8080
COPY target/*.jar /app/apimicroservice/*.jar
ENTRYPOINT ["java", "-jar", "/app/apimicroservice/*.jar"]