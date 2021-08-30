#!/bin/bash

REPO_DFN="-Dmdep.prependGroupId=true"
MAVEN_OPTS="-XX:+TieredCompilation -XX:TieredStopAtLevel=1"

if [ -n "$NEXUS_URL" ]; then
  REPO_DFN="$REPO_DFN --settings $SERVICE_HOME/settings.xml"
  cd "$SERVICE_HOME" || exit
  cat << EOF >  settings.xml
<?xml version="1.0" encoding="UTF-8"?>
<settings xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.1.0 http://maven.apache.org/xsd/settings-1.1.0.xsd"
  xmlns="http://maven.apache.org/SETTINGS/1.1.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
  <localRepository>/.m2</localRepository>
  <interactiveMode>true</interactiveMode>
  <usePluginRegistry>false</usePluginRegistry>
  <offline>false</offline>
  <servers> 
    <server> 
      <username><![CDATA[$NEXUS_USER]]></username> 
      <password><![CDATA[$NEXUS_PASSWORD]]></password> 
      <id>github</id> 
    </server> 
  </servers> 
  <profiles> 
    <profile> 
      <repositories> 
        <repository> 
          <id>github</id>
          <name>github</name> 
          <url>$NEXUS_URL</url>
          <snapshots><updatePolicy>always</updatePolicy></snapshots>
        </repository>
      </repositories>
      <id>github</id>
    </profile>
  </profiles>
  <activeProfiles>
    <activeProfile>github</activeProfile>
  </activeProfiles>
</settings>
EOF
fi

mvn dependency:copy \
 -DoutputDirectory=$SERVICE_HOME/pom \
 -Dartifact=$ARTIFACT:pom -U \
 -DincludeScope=compile \
 $REPO_DFN
mvn dependency:copy \
-DoutputDirectory=$SERVICE_HOME/target \
-Dartifact=$ARTIFACT:jar -U \
-DincludeScope=compile \
$REPO_DFN
mvn dependency:copy-dependencies \
  -f $SERVICE_HOME/pom/*.pom \
  -DincludeScope=compile \
  -DincludeScope=runtime \
  -DoutputDirectory=$SERVICE_HOME/target \
  $REPO_DFN
