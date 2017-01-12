#!/bin/bash

set -e

version=$(cat version/number)

# rename the artifact to the final version
cp candidate-release/ptq-*.war prepare-final-output/ptq-$version.war
