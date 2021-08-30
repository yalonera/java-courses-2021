FROM maven:3-jdk-8-alpine
EXPOSE 8888

ARG NEXUS_URL
ARG NEXUS_USER
ARG NEXUS_PASSWORD

ARG ARTIFACT
ARG ARTIFACT_MAIN_CLASS
ARG JAVA_OPTS

ENV SERVICE_HOME=/opt/service
RUN mkdir $SERVICE_HOME && cd $SERVICE_HOME
ADD ./java/entrypoint-java.sh  ./entrypoint-java.sh
ADD ./java/entrypoint-maven.sh ./entrypoint-maven.sh
RUN chmod +x ./entrypoint-java.sh
RUN chmod +x ./entrypoint-maven.sh
RUN mkdir ./target/

ENTRYPOINT ./entrypoint-maven.sh && ./entrypoint-java.sh
