#!/bin/bash

#FIXME: to define correctly the root dir of the projet.
#rootDir="."
#export CLASSPATH=/usr/share/java
#rm *.class
#javac Demo.java
#javac -cp ".:/usr/share/java/*" WEB-INF/src/org/happy/happytree/HelloWorld.java -d WEB-INF/classes/org/happy/happytree
#javac -cp ".:/usr/share/java/*" WEB-INF/src/org/happy/happytree/HelloWorld.java -d WEB-INF/classes
#javac -cp ".:/usr/share/java/*" WEB-INF/src/org/happy/happytree/*.java -d WEB-INF/classes
#rm -fr javadoc
#mkdir javadoc
#javadoc -cp ".:/usr/share/java/*" $rootDir/WEB-INF/src/org/happy/happytree/* -d javadoc
mvn clean package
