#!/usr/bin/env bash

cf cups ess-postgres -p '{"hostname":"10.1.7.4","port":"5432","name":"mastercard","username":"rdr_user_rl","uri":"postgresql://gpadmin:gpadmin@10.1.7.4:5432/mastercard?reconnect=true","jdbcUrl":"jdbc:postgresql://10.1.7.4:5432/mastercard?user=rdr_user_rl"}'