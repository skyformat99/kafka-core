package com.cgtz.kafka;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Future;

/**
 * Created by Administrator on 2017/9/15.
 */
public class KafkaProducer {

    private static org.apache.kafka.clients.producer.KafkaProducer<String,String> producer;

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    static {
        producer = new org.apache.kafka.clients.producer.KafkaProducer<>(KafkaConfig.producerConfig());
    }

    public static void publish(TopicEnum topicEnum,Object data){
        String msg = "发布成功";
        try {
            ProducerRecord<String,String> recordData = new ProducerRecord<>(topicEnum.key(),JsonUtil.toJson(data));
            Future<RecordMetadata> future = producer.send(recordData);
            //producer.close();
        }catch (Exception e){
            msg = "发布失败:"+e.getMessage();
        }finally {
            logger.error("Kafka producer----【topic:{}】----【message:{}】----【msg:{}】",topicEnum.key(),JsonUtil.toJson(data),msg);
        }
    }
}
