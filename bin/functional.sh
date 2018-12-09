#!/bin/bash

#javac src/org/gnuzero/trains/*.java -Xlint:unchecked
javac -cp ./lib/junit-4.12.jar src/org/gnuzero/trains/*.java tests/org/gnuzero/trains/*.java

#javac -d /absolute/path/for/compiled/classes -cp /absolute/path/to/junit-4.12.jar /absolute/path/to/TestClassName.java

java -cp ./src/:./tests/:./lib/junit-4.12.jar:./lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore org.gnuzero.trains.GraphFunctionalTests

