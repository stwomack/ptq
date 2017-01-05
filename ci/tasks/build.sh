#!/bin/ash

set -e -x

cd source-code
  ./mvnw clean package
cd ..

cp -fr source-code/ build-output