package com.natasatm.contentcalendar;

import com.natasatm.contentcalendar.config.ContentCalendarProperties;
import com.natasatm.contentcalendar.model.Content;
import com.natasatm.contentcalendar.model.Status;
import com.natasatm.contentcalendar.model.Type;
import com.natasatm.contentcalendar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
@EnableConfigurationProperties(ContentCalendarProperties.class)
@SpringBootApplication
public class  ContentCalendarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentCalendarApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ContentRepository repository){
		return args -> {
			// insert some data into the database
			Content c = new Content(
					null,
					"Hello",
					"All about ...",
					Status.IDEA,
					Type.VIDEO,
					LocalDateTime.now(),
					null,"");

			repository.save(c);


		};
	}

}
