package com.mail.fa;

import com.google.common.cache.LoadingCache;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@AllArgsConstructor
public class Mail2faApplication {
	private final LoadingCache<String,Integer> oneTimePasswordCache;
	private final String  email="nshivmohan08@gmail.com";

	public static void main(String[] args) {
		SpringApplication.run(Mail2faApplication.class, args);
	}

//	@PostConstruct
	public void init() throws ExecutionException, InterruptedException {
		Integer otp= oneTimePasswordCache.get(email);
		System.out.println("OTP - "+otp);
		oneTimePasswordCache.put(email, new Random().ints(1, 100000, 999999).sum());
		System.out.println(oneTimePasswordCache.get(email));
		TimeUnit.SECONDS.sleep(10);
		System.out.println(oneTimePasswordCache.get(email));
		TimeUnit.SECONDS.sleep(10);
		System.out.println(oneTimePasswordCache.get(email));
		TimeUnit.SECONDS.sleep(10);
		System.out.println(oneTimePasswordCache.get(email));
		TimeUnit.SECONDS.sleep(10);
		System.out.println(oneTimePasswordCache.get(email));
	}

}
