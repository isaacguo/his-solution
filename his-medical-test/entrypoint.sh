#!/bin/sh

set -e

JAVA_OPTS=${JAVA_OPTS:="-Xmx128m"}

exec java -jar $JAVA_OPTS /usr/share/myservice/myservice.jar $@
