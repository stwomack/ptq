#!/bin/ash

set -e -x

RESPONSE = `curl https://ptq.app.52.176.40.186.cf.pcfazure.com/info -k`

if [ $RESPONSE != '{"Property":{"key":"value"}}' ]; then
  exit -1;
fi

cp -fr build-output/. uat-output