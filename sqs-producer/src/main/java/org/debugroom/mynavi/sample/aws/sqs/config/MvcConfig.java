package org.debugroom.mynavi.sample.aws.sqs.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("org.debugroom.mynavi.sample.aws.sqs.app.web")
public class MvcConfig implements WebMvcConfigurer {
}
