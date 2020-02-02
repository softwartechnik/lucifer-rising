FROM jboss/wildfly

RUN /opt/jboss/wildfly/bin/add-user.sh admin vomBizepsSchrumpftDerSalat --silent

ADD lucifer-rising-ear/build/libs/lucifer-rising-ear-0.1.0-SNAPSHOT.ear /opt/jboss/wildfly/standalone/deployments/lucifer-rising-ear.ear

ENTRYPOINT /opt/jboss/wildfly/bin/standalone.sh -b=0.0.0.0 -bmanagement=0.0.0.0 -Djboss.node.name=softwartechnik