#FROM java:8-jre
FROM openjdk:8-jre

ADD ./target/msa-svc-ui.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/msa-svc-ui.jar"]

EXPOSE 9093