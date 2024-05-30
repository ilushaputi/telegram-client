package ru.putintsev.rogaandkopyta.telegramclient.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;

@Configuration
@EnableAutoConfiguration
@RequiredArgsConstructor
@ComponentScan(basePackages = {"ru.putintsev.rogaandkopyta.telegramclient", "ru.putintsev.rogaandkopyta.telegramclient.feign"})
public class AppConfig {

    private final Environment env;

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        ResourceBundleMessageSource commonMessageSource = new ResourceBundleMessageSource();
        commonMessageSource.setBasename("common_messages");
        commonMessageSource.setDefaultEncoding("UTF-8");
        messageSource.setParentMessageSource(commonMessageSource);
        return messageSource;
    }
}
