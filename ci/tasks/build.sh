#!/bin/ash

set -e -x

cd source-code
  ./mvnw clean package
cd ..

cp source-code/target/processed-transactions-query-0.0.1-SNAPSHOT.jar build-output/.