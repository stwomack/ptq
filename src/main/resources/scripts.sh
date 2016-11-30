#!/usr/bin/env bash

GCP:
cf cups mess-postgres -p '{"hostname":"10.0.0.230","port":"5432","name":"ess","username":"rdr_user_rl","password":"pivotal","uri":"postgresql://gpadmin:gpadmin@10.0.0.230:5432/ess?reconnect=true","jdbcUrl":"jdbc:postgresql://10.0.0.230:5432/ess?user=rdr_user_rl"}'

WWT:
cf cups ess-postgres -p '{"hostname":"10.2553.80.11","port":"5432","name":"mcdb","username":"rdr_user_rl","password":"pivotal","uri":"postgresql://gpadmin:gpadmin@10.253.80.11:5432/mcdb?reconnect=true","jdbcUrl":"jdbc:postgresql://10.255.178.40:5432/mcdb?user=rdr_user_rl"}'

something

cf cups ess-postgres -p "hostname,port,name,username,password,uri,jdbcUrl"
hostname> 10.0.0.230
port> 5432
name> ess
username> gpadmin
password> gpadmin
uri> postgresql://gpadmin:gpadmin@10.0.0.230:5432/ess?reconnect=true
jdbcUrl> jdbc:postgresql://10.0.0.230:5432/ess?user=gpadmin