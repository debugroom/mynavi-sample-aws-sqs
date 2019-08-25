package org.debugroom.mynavi.sample.aws.sqs.app.function;

import java.util.function.Function;

import com.amazonaws.services.s3.event.S3EventNotification;
import com.amazonaws.services.s3.event.S3EventNotification.S3EventNotificationRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;

import reactor.core.publisher.Flux;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SampleFunction implements
        Function<Flux<S3EventNotification>, Flux<String>> {

    @Autowired
    QueueMessagingTemplate queueMessagingTemplate;

    @Override
    public Flux<String> apply(Flux<S3EventNotification> s3EventNotificationFlux) {
        s3EventNotificationFlux.subscribe(s3EventNotification -> {
            if(s3EventNotification.getRecords().size() != 0){
                S3EventNotificationRecord record = s3EventNotification.getRecords().get(0);
                String keyName = record.getS3().getObject().getKey();
                queueMessagingTemplate.convertAndSend("MynaviSampleSqsQueue", keyName);
                log.info("complete!" + keyName);
            }
        });
        return Flux.just("Complete!");
    }

}
