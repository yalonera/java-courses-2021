#!/bin/bash -ex

JAVA_HOME=/usr/lib/jvm/default-jvm
PATH=$PATH:/usr/lib/jvm/default-jvm/bin/

[ -e /config/RUNNING_PID ] && rm /config/RUNNING_PID

java $JAVA_OPTS -cp "$SERVICE_HOME/target/*" $ARTIFACT_MAIN_CLASS