# How to Kafka
Producer and consumer for kafka

## Intro
For running the example producer and consumer, we first need to setup Zookeeper
and Kafka, where Zookeeper is a coordination system for Kafka, and is handling
all coordination around joining and leaving nodes. Kafka nodes joins through
Zookeeper and get some configuration parameters through it. 

The Producer is using Kafka asynchron interface, so a send message functions
through a callback, that will log that a message have been sent, when Kafka have
acknowledge the message.



## Setup
1. Download [Kafka](https://www.apache.org/dyn/closer.cgi?path=/kafka/1.1.0/kafka_2.11-1.1.0.tgz)
2. Unpack the files to a folder in to root called Kafka
3. Run `cd scripts`
4. Run `./start_zookeeper.sh` this will start a Zookeeper instanse, which Kafka node
   can join.
5. Run `./start_kafka` which starts a single kafka node and joins Zookeeper.
6. Run `./create_topics` which creates a new topic named `test-topic` with a
   partition value of 13

## Run

With Zookeeper and Kafka running, the producer and consumer is able to run, at
the moment both have hardcoded values for establising the connection and
subscribing to `test-topic`.
