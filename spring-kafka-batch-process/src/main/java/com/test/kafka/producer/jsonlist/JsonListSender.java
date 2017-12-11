package com.test.kafka.producer.jsonlist;

import java.util.List;

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


public class JsonListSender {

  private static final Logger LOGGER = LoggerFactory.getLogger(JsonListSender.class);

  @Value("${kafka.topic.batch}")
  private String jsonTopic;

  @Autowired
  private KafkaTemplate<String, List<Deal>> kafkaTemplate;

  public void send(List<Deal> dealList) {
    LOGGER.info("Sending count of Deal = ", dealList.size());
    kafkaTemplate.send(jsonTopic, dealList);
  }
}
