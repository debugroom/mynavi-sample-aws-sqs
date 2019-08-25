package org.debugroom.mynavi.sample.aws.sqs.app.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.s3.event.S3EventNotification;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public class S3UploadEventHandler extends
        SpringBootRequestHandler<S3EventNotification, String> {

    @Override
    public Object handleRequest(S3EventNotification event, Context context) {
        return super.handleRequest(event, context);
    }

}
