package ru.alexanderFrank.NauJava;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.alexanderFrank.NauJava.CommandProcessor.CommandProcessor;

@SpringBootApplication
public class NauJavaApplication {

	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		CommandLineRunner commandRunner = context.getBean(CommandLineRunner.class);
		commandRunner.run(args);
	}

}
