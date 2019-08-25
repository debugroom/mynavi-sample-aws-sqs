package org.debugroom.mynavi.sample.aws.sqs.domain.repository;

import org.debugroom.mynavi.sample.aws.sqs.domain.model.Sample;

public interface SampleRepository {

    public void save(Sample sample);

}
