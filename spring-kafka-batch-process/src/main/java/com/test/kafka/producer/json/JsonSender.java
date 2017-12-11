package com.test.kafka.producer.json;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

import com.test.model.Deal;

/**
 * @author Karoonakar Jaiswal
 *
 */

public class JsonSender {

  private static final Logger LOGGER = LoggerFactory.getLogger(JsonSender.class);

  @Value("${kafka.topic.batch}")
  private String jsonTopic;

  @Autowired
  private KafkaTemplate<String, Deal> kafkaTemplate;

  public void send(Deal deal) {
    LOGGER.info("sending Deal='{}'", deal.toString());
    kafkaTemplate.send(jsonTopic, deal);
  }
}
