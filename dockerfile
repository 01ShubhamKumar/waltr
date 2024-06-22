FROM openjdk:8
COPY target/spring-boot-docker-app.jar  /waltr/waltr/
WORKDIR ./waltr/waltr/
ENTRYPOINT ["java", "-jar", "spring-boot-docker-app.jar"]

