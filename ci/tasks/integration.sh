#!/bin/bash

set -e

pushd ptq
  ./mvnw clean verify
popd
