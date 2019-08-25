package org.debugroom.mynavi.sample.aws.sqs.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class BatchInfraConfig {

    @Bean(name="batchDataSource")
    public DataSource jocRepositoryEmbeddedDataSource(){
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:/org/springframework/batch/core/schema-h2.sql")
                .build();
    }
}

