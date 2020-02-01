FROM jboss/wildfly
ADD lucifer-rising-chat/build/libs/lucifer-rising-chat-1.0.0-SNAPSHOT.jar /opt/jboss/wildfly/standalone/deployments/
ADD lucifer-rising-ear/build/libs/lucifer-rising-ear-0.1.0-SNAPSHOT.ear /opt/jboss/wildfly/standalone/deployments/
ADD lucifer-rising-user/build/libs/lucifer-rising-user-1.0.0-SNAPSHOT.jar /opt/jboss/wildfly/standalone/deployments/
