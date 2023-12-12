package com.mail.fa;

import com.google.common.cache.LoadingCache;
import com.mail.fa.entity.User;
import com.mail.fa.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@SpringBootApplication
@AllArgsConstructor
public class Mail2faApplication {
	private final LoadingCache<String,Integer> oneTimePasswordCache;
	private final String  email="nshivmohan08@gmail.com";
	private final UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Mail2faApplication.class, args);
	}

	@PostConstruct
	public void init() throws ExecutionException, InterruptedException {
		User user=new User();
		user.setActive(true);
		user.setEmailId("nshivmohan0g81w@gmail.com");
		user.setEmailVerified(true);
		user.setPassword("Shiv");
		System.out.println("Saved-"+userRepository.save(user));
		final var response=userRepository.findById(UUID.fromString("ec08dc93-50d5-4395-88da-255947d444c1")).get();
		System.out.println("Response-"+response);
	}

}
