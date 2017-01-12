#!/bin/bash

set -e

version=$(cat version/number)

pushd ptq
  ./mvnw clean package -Pci -DversionNumber=$version
popd

# Copy war file to build output folder
artifact="ptq-$version.war"

cp ptq/target/$artifact build-output/$artifact
