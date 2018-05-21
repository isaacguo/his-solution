#!/bin/sh

set -e

JAVA_OPTS=${JAVA_OPTS:="-Xmx32m"}

exec java -jar $JAVA_OPTS /usr/share/myservice/myservice.jar $@
