package com.mmedum.howtokafka;


import com.mmedum.howtokafka.producer.MessageProducer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private final static Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args){
        LOGGER.setLevel(Level.INFO);
        LOGGER.info("Starting up");
        MessageProducer producer = new MessageProducer();
        producer.runMessageProducer(10);

    }
}
