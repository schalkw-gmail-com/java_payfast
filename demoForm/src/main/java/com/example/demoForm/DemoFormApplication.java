package com.example.demoForm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoFormApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoFormApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(DemoFormApplication.class);

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Subscription subscription = restTemplate.getForObject(
					"https://api.payfast.pf.schalk/subscriptions/7bfce38d-5103-4133-a64b-a16033bdb538/f", Subscription.class);
			log.info(subscription.toString());
		};
	}
	//curl -v -X PUT -H “merchant-id: 10000100” -H “version: v1” -H “timestamp=2016-04-01T12:00:01” -H “signature=840654b40a8b312e54650e1613696b44” https://api.payfast.pf.schalk/subscriptions/7bfce38d-5103-4133-a64b-a16033bdb538
}
//https://api.payfast.co.za/subscriptions/dc0521d3-55fe-269b-fa00-b647310d760f/f
//
//		127.0.0.1    api.payfast.pf.schalk
//		127.0.0.1    api.payfast.local
//		127.0.0.1    api.payfast.schalk
