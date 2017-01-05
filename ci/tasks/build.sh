#!/bin/ash

set -e -x

cd source-code
  ./mvnw clean package
cd ..

cp source-code/ build-output/.