FROM amazoncorretto:21

LABEL maintainer="ErenJaeger"

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
