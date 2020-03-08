#FROM java:8-jre
FROM openjdk:8-jre

ADD ./target/msa-svc-order.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/msa-svc-order.jar"]

EXPOSE 9092