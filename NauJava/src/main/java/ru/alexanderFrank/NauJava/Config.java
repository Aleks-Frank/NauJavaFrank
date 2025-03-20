package ru.alexanderFrank.NauJava;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import ru.alexanderFrank.NauJava.CommandProcessor.CommandProcessor;
import ru.alexanderFrank.NauJava.Entity.Contact;
import ru.alexanderFrank.NauJava.Repository.ContactRepository;
import ru.alexanderFrank.NauJava.Repository.ContactRepositoryIMPL;
import ru.alexanderFrank.NauJava.Service.UserContactService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class Config {

    @Value("${app.name}")
    private String nameApplication;

    @Value("${app.version}")
    private String versionApplication;

    @PostConstruct
    private void init(){
        System.out.println(nameApplication);
        System.out.println(versionApplication);
    }

    @Bean
    @Scope(value = BeanDefinition.SCOPE_SINGLETON)
    public List<Contact> listContacts(){
        return new ArrayList<>();
    }

    @Bean
    public UserContactService userContactService(ContactRepository contactRepository) {
        return new UserContactService(contactRepository);
    }

    @Bean
    public ContactRepository contactRepository() {
        return new ContactRepositoryIMPL(listContacts());
    }

    @Autowired
    private CommandProcessor commandProcessor;

    @Bean
    public CommandLineRunner commandScanner(){
        return args -> {
            try (Scanner scanner = new Scanner(System.in)){
                System.out.println("Ввести команду \nadd id name phone \nupdate id name phone " +
                        "\nfindId id \nfindName \nshow \nexit");
                while (true){
                    System.out.println("> ");
                    String input = scanner.nextLine();
                    if("exit".equalsIgnoreCase(input.trim())){
                        System.out.println("Выход из программы...");
                        break;
                    }
                    commandProcessor.processCommand(input);
                }
            }
        };
    }

}
