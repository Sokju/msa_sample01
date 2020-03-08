#FROM java:8-jre
FROM openjdk:8-jre

ADD ./target/msa-svc-member.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/msa-svc-member.jar"]

EXPOSE 9091