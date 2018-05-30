FROM openjdk:10.0
MAINTAINER 金飞 <28206254@qq.com>
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.war
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.war"]