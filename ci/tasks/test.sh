#!/bin/ash

set -e -x

RESPONSE=`wget -qO- http://ptq.app.52.176.40.186.cf.pcfazure.com/info`

echo $RESPONSE

#cp -fr build-output/. uat-output