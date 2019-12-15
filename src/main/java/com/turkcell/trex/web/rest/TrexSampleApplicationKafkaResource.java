package com.turkcell.trex.web.rest;

import com.turkcell.trex.service.TrexSampleApplicationKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trex-sample-application-kafka")
public class TrexSampleApplicationKafkaResource {

    private final Logger log = LoggerFactory.getLogger(TrexSampleApplicationKafkaResource.class);

    private TrexSampleApplicationKafkaProducer kafkaProducer;

    public TrexSampleApplicationKafkaResource(TrexSampleApplicationKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
