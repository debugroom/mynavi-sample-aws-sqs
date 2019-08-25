package org.debugroom.mynavi.sample.aws.sqs.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Component;

import org.debugroom.mynavi.sample.aws.sqs.domain.model.Sample;

@Component
public class SampleRepositoryImpl implements SampleRepository{

    @Autowired
    QueueMessagingTemplate queueMessagingTemplate;

    @Override
    public void save(Sample sample) {
        queueMessagingTemplate.convertAndSend("MynaviSampleSqsQueue", sample.getMessage());
    }

}
