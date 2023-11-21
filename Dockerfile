FROM quay.io/wildfly/wildfly
COPY target/lab2.war /opt/jboss/wildfly/standalone/deployments/
