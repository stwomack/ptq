#!/usr/bin/env bash
cf cups ess-postgres -p '{"username":"gpadmin","password":"gpadmin","host":"10.253.80.11","port":"5432","dbname":"ess"}'

cf cups ess-postgres -p '{"hostname":"10.0.0.230","port":"5432","name":"ess","username":"rdr_user_rl","password":"pivotal","uri":"postgresql://gpadmin:gpadmin@10.0.0.230:5432/ess?reconnect=true","jdbcUrl":"jdbc:postgresql://10.0.0.230:5432/ess?user=rdr_user_rl"}'

cf cups ess-postgres -p "hostname,port,name,username,password,uri,jdbcUrl"
hostname> 10.0.0.230
port> 5432
name> ess
username> gpadmin
password> gpadmin
uri> postgresql://gpadmin:gpadmin@10.0.0.230:5432/ess?reconnect=true
jdbcUrl> jdbc:postgresql://10.0.0.230:5432/ess?user=gpadmin