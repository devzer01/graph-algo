#!/bin/bash

echo "Cleaning"
rm src/org/gnuzero/trains/*.class tests/org/gnuzero/trains/*.class

echo "Compiling classes"
javac -cp ./lib/junit-4.12.jar src/org/gnuzero/trains/*.java tests/org/gnuzero/trains/*.java



java -cp ./src/:./tests/:./lib/junit-4.12.jar:./lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore org.gnuzero.trains.NodeTests
java -cp ./src/:./tests/:./lib/junit-4.12.jar:./lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore org.gnuzero.trains.MapFileReaderTest
java -cp ./src/:./tests/:./lib/junit-4.12.jar:./lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore org.gnuzero.trains.GraphTest
java -cp ./src/:./tests/:./lib/junit-4.12.jar:./lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore org.gnuzero.trains.PathTests