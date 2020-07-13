FROM jenkins/jnlp-slave:alpine
LABEL maintainer="Amit Kshirsagar <amit.kshirsagar.13@gmail.com>"

USER root
RUN apk add --no-cache curl tar bash

ARG MAVEN_VERSION=3.6.3

ARG BASE_URL=https://apache.osuosl.org/maven/maven-3/${MAVEN_VERSION}/binaries

RUN mkdir -p /usr/share/maven /usr/share/maven/ref \
  && echo "Downlaoding maven" \
  && curl -fsSL -o /tmp/apache-maven.tar.gz ${BASE_URL}/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
  \
  && echo "Unziping maven" \
  && tar -xzf /tmp/apache-maven.tar.gz -C /usr/share/maven --strip-components=1 \
  \
  && echo "Cleaning and setting links" \
  && rm -f /tmp/apache-maven.tar.gz \
  && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

ENV MAVEN_HOME /usr/share/maven

ARG MAVEN_HOME_DIR="/maven"
ENV MAVEN_CONFIG "$MAVEN_HOME_DIR/.m2"

USER jenkins
