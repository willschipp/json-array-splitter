package com.example.code.xd;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;


@Configuration
@EnableIntegration
public class ModuleConfiguration {

	@Bean
	MessageChannel input() {
		return new DirectChannel();
	}
	
	@Bean
	MessageChannel output() {
		return new DirectChannel();
	}
	
	@Bean
	JSONArraySplitter splitter() {
		return new JSONArraySplitter();
	}
}
