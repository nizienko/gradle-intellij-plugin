FROM consol/ubuntu-xfce-vnc

USER 0

RUN rm /bin/sh && ln -s /bin/bash /bin/sh
RUN apt-get -y update && apt-get upgrade -y

# Java
RUN apt-get -y update && apt-get install -y openjdk-8-jdk openjfx
ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64

#RUN apt-get install -y curl
#RUN apt-get install -y unzip

# Gradle
#RUN wget https://services.gradle.org/distributions/gradle-4.10-bin.zip
#RUN mkdir /opt/gradle
#RUN unzip -d /opt/gradle gradle-4.10-bin.zip
#
#ENV GRADLE_HOME /opt/gradle/gradle-4.10
#ENV PATH="${GRADLE_HOME}/bin:${PATH}"

USER 1000