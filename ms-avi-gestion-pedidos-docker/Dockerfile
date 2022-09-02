FROM openjdk:11.0.15
ADD build/libs/test1*.jar test1.jar
EXPOSE 8097
ENTRYPOINT ["java", "-jar","-Xms256m","-Xmx2048m","test1.jar"]