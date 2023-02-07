#! /bin/sh

./gradlew bootJar
aws s3 cp build/libs/theater-0.0.1-SNAPSHOT.jar s3://theater-jars
