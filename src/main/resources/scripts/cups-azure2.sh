#!/usr/bin/env bash

cf cups ess-postgres -p '{"hostname":"10.128.0.12","port":"5432","name":"mastercard","username":"rdr_user_rl","password":"pivotal","uri":"postgresql://gpadmin:gpadmin@10.128.0.12:5432/mastercard?reconnect=true","jdbcUrl":"jdbc:postgresql://10.128.0.12:5432/mastercard?user=rdr_user_rl"}'