#FROM java:8-jre
FROM openjdk:8-jre

ENV CONFIG_SERVICE_NAME msa-config-server
ENV PROFILES dev
ENV JAR_FILE msa-config-server.jar

ADD ./target/${JAR_FILE} /app/
ENTRYPOINT [ "sh", "-c" ]
CMD ["exec java -Xmx200m -Dspring.profiles.active=${PROFILES} -jar /app/${JAR_FILE}"]

HEALTHCHECK --interval=30s --timeout=30s CMD curl -f http://localhost:8888/actuator/health || exit 1

EXPOSE 8888