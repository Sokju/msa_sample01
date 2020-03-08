#FROM java:8-jre
FROM openjdk:8-jre

ADD ./target/msa-auth-server.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/msa-auth-server.jar"]

EXPOSE 9080