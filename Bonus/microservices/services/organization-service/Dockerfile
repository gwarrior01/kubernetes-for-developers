FROM eclipse-temurin:21-jdk-alpine AS builder
WORKDIR /builder
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=tools -jar application.jar extract --layers --destination extracted

FROM eclipse-temurin:21-jdk-alpine
ADD /trace/opentelemetry-javaagent.jar /opt/app/opentelemetry-javaagent.jar
WORKDIR /application
COPY --from=builder /builder/extracted/dependencies/ ./
COPY --from=builder /builder/extracted/spring-boot-loader/ ./
COPY --from=builder /builder/extracted/snapshot-dependencies/ ./
COPY --from=builder /builder/extracted/application/ ./

ENTRYPOINT ["java"]
CMD ["-jar", "application.jar", "-javaagent:/opt/app/opentelemetry-javaagent.jar"]