package org.belotelov.reminders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class RemindersApplication {

	public static void main(String[] args) {

		SpringApplication.run(RemindersApplication.class, args);
	}
}
