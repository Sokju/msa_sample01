FROM java:8-jre

ADD ./target/msa-zipkin-server.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/msa-zipkin-server.jar"]

EXPOSE 9411
