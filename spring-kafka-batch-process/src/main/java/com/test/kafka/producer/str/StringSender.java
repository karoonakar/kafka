package com.test.kafka.producer.str;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @author Karoonakar Jaiswal
 *
 */

public class StringSender {

  private static final Logger LOGGER = LoggerFactory.getLogger(StringSender.class);

  @Value("${kafka.topic.batch}")
  private String topic;
  
  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  public void send(String data) {
    LOGGER.info("sending data='{}' to topic='{}'", data, topic);
    kafkaTemplate.send(topic, data);
  }
}
