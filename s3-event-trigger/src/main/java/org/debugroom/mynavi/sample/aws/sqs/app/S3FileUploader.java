package org.debugroom.mynavi.sample.aws.sqs.app;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.amazonaws.util.IOUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.WritableResource;

public class S3FileUploader {

    private static final String S3_BUCKET_PREFIX = "s3://";

    @Value("${bucket.name}")
    private String bucketName;

    @Autowired
    ResourceLoader resourceLoader;

    public String saveFile(String classPathFileResource){
        String objectKey = new StringBuilder()
                .append(S3_BUCKET_PREFIX)
                .append(bucketName)
                .append(classPathFileResource)
                .toString();
        WritableResource writableResource = (WritableResource)resourceLoader.getResource(objectKey);
        try(InputStream inputStream = getClass().getResourceAsStream(classPathFileResource);
            OutputStream outputStream = writableResource.getOutputStream()){
            IOUtils.copy(inputStream, outputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
        return objectKey;
    }
}
