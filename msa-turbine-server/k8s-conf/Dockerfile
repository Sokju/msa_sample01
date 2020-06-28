#FROM java:8-jre
FROM openjdk:8-jre

ENV CONFIG_SERVICE_NAME msa-config-server
ENV PROFILES dev
ENV JAR_FILE msa-turbine-server.jar

ADD ./target/${JAR_FILE} /app/
ENTRYPOINT [ "sh", "-c" ]
CMD ["exec java -Xmx512m -Dspring.profiles.active=${PROFILES} -jar /app/${JAR_FILE}"]

EXPOSE 9010