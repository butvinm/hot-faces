FROM quay.io/wildfly/wildfly
COPY target/lab2.war /opt/jboss/wildfly/standalone/deployments/
COPY --chmod=0755 standalone.sh /opt/jboss/wildfly/bin/
CMD /opt/jboss/wildfly/bin/standalone.sh --debug -b 0.0.0.0
