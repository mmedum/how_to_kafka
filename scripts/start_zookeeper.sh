#!/usr/bin/env bash

PREFIX_BIN=../kafka/bin
PREFIX_CONFIG=../kafka/config

## Start Zookeeper
$PREFIX_BIN/zookeeper-server-start.sh $PREFIX_CONFIG/zookeeper.properties
