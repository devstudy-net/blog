# Build:
# docker build -t devstudy/blog-web-server:1.0 -f docker/blog-web-server.dockerfile .
#
FROM devstudy/tomcat:8

MAINTAINER devstudy.net

ARG TOMCAT_ROOT=/opt/tomcat

RUN rm -rf ${TOMCAT_ROOT}/ROOT
ADD target/ROOT/ ${TOMCAT_ROOT}/webapps/ROOT/
ADD docker/app/application.properties ${TOMCAT_ROOT}/webapps/ROOT/WEB-INF/classes/
ADD docker/app/wait-for-service-up.sh /wait-for-service-up.sh
RUN chmod +x /wait-for-service-up.sh