FROM openjdk:8-jre-alpine
MAINTAINER Isaac Guo <isaac_guo@163.com>


# Add Maven dependencies (not shaded into the artifact; Docker-cached)
#ADD target/lib           /usr/share/myservice/lib
# Add the service itself

ARG JAR_FILE
ARG IMAGE_VERSION

ADD target/${JAR_FILE} /usr/share/myservice/myservice.jar
ADD entrypoint.sh /entrypoint.sh

LABEL version=${IMAGE_VERSION}

ENTRYPOINT ["./entrypoint.sh"]

