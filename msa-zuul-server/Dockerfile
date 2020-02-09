FROM java:8-jre

ADD ./target/msa-zuul-server.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/msa-zuul-server.jar"]

EXPOSE 9090