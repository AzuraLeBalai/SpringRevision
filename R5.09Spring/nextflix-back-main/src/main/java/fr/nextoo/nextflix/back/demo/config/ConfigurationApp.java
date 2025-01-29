package fr.nextoo.nextflix.back.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class ConfigurationApp {

	@Bean(name = "database")
	public DataBase initDB(){
		DataBase db = DataBase.getInstance();
		db.setCurrentIdSession(1);
		return db;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		configurer.setLocation(new FileSystemResource(".env"));
		return configurer;
	}
}
