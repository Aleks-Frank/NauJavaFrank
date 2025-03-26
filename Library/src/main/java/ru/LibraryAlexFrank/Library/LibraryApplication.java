package ru.LibraryAlexFrank.Library;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		CommandLineRunner commandLineRunner = context.getBean(CommandLineRunner.class);
		commandLineRunner.run(args);
	}

}
