#!/bin/bash

set -e

version=$(cat version/number)

# rename the artifact to the final version
cp candidate-release/ptq-*.jar prepare-final-output/ptq-$version.jar
