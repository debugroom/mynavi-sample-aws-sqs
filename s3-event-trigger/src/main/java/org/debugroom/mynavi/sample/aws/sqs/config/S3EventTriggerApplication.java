package org.debugroom.mynavi.sample.aws.sqs.config;

import org.debugroom.mynavi.sample.aws.sqs.app.S3FileUploader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class S3EventTriggerApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                SpringApplication.run(S3EventTriggerApplication.class, args);
        S3FileUploader s3FileUploader = applicationContext.getBean(S3FileUploader.class);
        s3FileUploader.saveFile("/test-sqs.txt");
    }

    @Bean
    public S3FileUploader s3FileUploader(){
        return new S3FileUploader();
    }

}
