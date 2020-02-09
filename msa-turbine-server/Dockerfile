FROM java:8-jre

ADD ./target/msa-turbine-server.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/msa-turbine-server.jar"]

EXPOSE 9010