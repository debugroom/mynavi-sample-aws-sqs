package org.debugroom.mynavi.sample.aws.sqs.app.web;

import org.debugroom.mynavi.sample.aws.sqs.domain.model.Sample;
import org.debugroom.mynavi.sample.aws.sqs.domain.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class SampleRestController {

    @Autowired
    SampleRepository sampleRepository;

    @GetMapping("/batch")
    public String batch(String message){
        sampleRepository.save(
                Sample.builder()
                        .message(message)
                        .build()
        );
        return "Queue accepted.";
    }

}
