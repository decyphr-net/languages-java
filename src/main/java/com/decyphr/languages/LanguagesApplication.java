package com.decyphr.languages;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.decyphr.languages.languages.LanguagesManager;
import com.decyphr.languages.languages.LanguagesSingleton;
import com.decyphr.languages.lifecycle.StartupManager;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class LanguagesApplication {

	LanguagesSingleton languagesSingleton = LanguagesSingleton.getInstance();
	LanguagesManager languagesManager;
	StartupManager startupManager;

	public LanguagesApplication(
			LanguagesManager languagesManager, StartupManager startupManager) {
		this.languagesManager = languagesManager;
		this.startupManager = startupManager;
	}

	public static void main(String[] args) {
		SpringApplication.run(LanguagesApplication.class, args);
	}

	@PostConstruct
	public void run() {
		log.info("MyApplication::run");
		startupManager.populateLanguageCache();
	}

}
