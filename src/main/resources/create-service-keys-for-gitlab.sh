#!/usr/bin/env bash
cf create-service-key my-mysql gitlab-mysql
cf create-service-key my-redis gitlab-redis
cf service-key my-redis gitlab-redis
cf service-key my-mysql gitlab-mysql