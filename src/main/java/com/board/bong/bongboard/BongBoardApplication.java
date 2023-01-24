package com.board.bong.bongboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BongBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(BongBoardApplication.class, args);
	}

}
