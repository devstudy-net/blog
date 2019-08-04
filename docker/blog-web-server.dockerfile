#
# @author devstudy
# @see http://devstudy.net
#
# docker build -t devstudy/blog-web-server:1.0 -f docker/blog-web-server.dockerfile .
#
FROM devstudy/tomcat:8

RUN rm -rf /opt/tomcat/ROOT
ADD target/ROOT/ /opt/tomcat/webapps/ROOT/
ADD docker/app/application.properties /opt/tomcat/webapps/ROOT/WEB-INF/classes/
ADD docker/app/wait-for-service-up.sh /wait-for-service-up.sh
RUN chmod +x /wait-for-service-up.sh