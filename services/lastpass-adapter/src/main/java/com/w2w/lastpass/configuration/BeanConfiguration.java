package com.w2w.lastpass.configuration;

import com.w2w.lastpass.client.LastPassCliClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public LastPassCliClient lastPassCliClient() {
        return new LastPassCliClient();
    }
}
