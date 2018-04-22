#!/usr/bin/env bash

PREFIX_BIN=../kafka/bin
PREFIX_CONFIG=../kafka/config

## Start Kafka
$PREFIX_BIN/kafka-server-start.sh $PREFIX_CONFIG/server.properties


