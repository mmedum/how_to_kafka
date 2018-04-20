#!/usr/bin/env bash
cd ~/kafka-training

## Create topics
kafka/bin/kafka-topics.sh --create \
    --replication-factor 3 \
    --partitions 13 \
    --topic test-topic \
    --zookeeper  localhost:2181


## List created topics
kafka/bin/kafka-topics.sh --list \
    --zookeeper localhost:2181
