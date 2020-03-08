#FROM java:8-jre
FROM openjdk:8-jre

ADD ./target/msa-eureka-server.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/msa-eureka-server.jar"]

EXPOSE 8761