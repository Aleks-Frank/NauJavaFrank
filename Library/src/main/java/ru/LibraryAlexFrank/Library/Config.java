package ru.LibraryAlexFrank.Library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.LibraryAlexFrank.Library.CommandProcessor.CommandProcessor;
import ru.LibraryAlexFrank.Library.DBRepository.BookDBRepository;
import ru.LibraryAlexFrank.Library.Entity.Book;
import ru.LibraryAlexFrank.Library.Repository.BookRepository;
import ru.LibraryAlexFrank.Library.Repository.BookRepositoryIMPL;
import ru.LibraryAlexFrank.Library.Service.UserLibraryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Configuration
@ComponentScan
public class Config {

    @Bean
    @Scope(value = BeanDefinition.SCOPE_SINGLETON)
    public List<Book> library(){
        return new ArrayList<>();
    }

    @Bean
    public UserLibraryService userLibraryService(BookRepository bookRepository){
        return new UserLibraryService(bookRepository);
    }

    @Bean
    public BookRepository bookRepository(){
        return new BookRepositoryIMPL(library());
    }

    @Autowired
    private CommandProcessor commandProcessor;

    @Autowired
    private BookDBRepository bookDBRepository;

    @Bean
    public CommandLineRunner commandScanner(){
        return args -> {
            try (Scanner scanner = new Scanner(System.in)){
                System.out.println("Введите команду \ncreate_book \nupdate_book \nfind_book_by_name " +
                        "\ndelete_book \nfind_by_id \nshow_all_book");
                while (true){
                    System.out.print("> ");
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
