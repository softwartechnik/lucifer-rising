FROM jboss/wildfly
ADD lucifer-rising-chat /opt/jboss/wildfly/standalone/deployments/
ADD lucifer-rising-ear /opt/jboss/wildfly/standalone/deployments/
ADD lucifer-rising-user /opt/jboss/wildfly/standalone/deployments/
