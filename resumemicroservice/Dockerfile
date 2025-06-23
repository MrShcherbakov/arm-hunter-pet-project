FROM eclipse-temurin:17-jre-jammy
WORKDIR /app/resumemicroservice
COPY target/*.jar /app/resumemicroservice/*.jar
ENTRYPOINT [ "java", "-jar", "/app/resumemicroservice/*.jar" ]