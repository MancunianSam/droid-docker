FROM openjdk:alpine
WORKDIR /tmp/
RUN apk add --no-cache wget && \
    wget https://cdn.nationalarchives.gov.uk/documents/container-signature-20220704.xml && \
    wget https://cdn.nationalarchives.gov.uk/documents/DROID_SignatureFile_V107.xml && \
    mkdir /tmp/files
COPY target/droid-docker-1.0-SNAPSHOT-jar-with-dependencies.jar /tmp
CMD java -cp /tmp/droid-docker-1.0-SNAPSHOT-jar-with-dependencies.jar uk.gov.nationalarchives.App
