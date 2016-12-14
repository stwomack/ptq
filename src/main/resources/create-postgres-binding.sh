#!/usr/bin/env bash

cf cups ess-postgres -p '{"hostname":"10.253.80.11","port":"5432","name":"ess","username":"rdr_user_rl","password":"pivotal","uri":"postgresql://gpadmin:gpadmin@10.253.80.11:5432/mcdb?reconnect=true","jdbcUrl":"jdbc:postgresql://10.253.80.11:5432/mcdb?user=rdr_user_rl"}'