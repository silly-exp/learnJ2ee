#!/bin/bash

APP_PATH="/var/lib/tomcat8/webapps"

rm -fr  $APP_PATH/nico
#mkdir $APP_PATH/nico
#cp -r WEB-INF $APP_PATH/nico
cp target/happyTree.war $APP_PATH