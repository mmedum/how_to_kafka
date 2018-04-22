#!/usr/bin/env bash

PREFIX_BIN=../kafka/bin
PREFIX_CONFIG=../kafka/config

## Create topics
$PREFIX_BIN/kafka-topics.sh --create --replication-factor 1 --partitions 13 --topic test-topic --zookeeper localhost:2181

## List created topics
$PREFIX_BIN/kafka-topics.sh --list --zookeeper localhost:2181
