FROM tomcat:8-jdk11
RUN mkdir /usr/local/tomcat/json
ADD target/jsp-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/jsp.war
EXPOSE 8080
WORKDIR /usr/local/tomcat/json
CMD ["catalina.sh", "run"]



