FROM openjdk:11.0.7
ADD build/libs/ms-gestion-alumno-*.jar ms-gestion-alumno.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar","-Xms256m","-Xmx2048m","ms-gestion-alumno.jar"]