package com.cgtz.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaCoreApplication {

	public static void main(String[] args) {
		//SpringApplication.run(KafkaCoreApplication.class, args);


		for(int i=0;i<2;i++){
			KafkaProducer.publish(TopicEnum.TOPIC_TEST,"test-kafka-"+i);
		}
	}
}
