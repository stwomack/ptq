#!/usr/bin/env bash

set -e -x

fly -t ci login -u concourse -p changeme -c http://localhost:8080
fly -t ci set-pipeline --pipeline ptq --config pipeline.yml --load-vars-from .cf-env.yml
fly -t ci unpause-pipeline --pipeline ptq