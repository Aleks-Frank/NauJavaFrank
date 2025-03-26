package ru.LibraryAlexFrank.Library.CommandProcessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.LibraryAlexFrank.Library.Entity.Book;
import ru.LibraryAlexFrank.Library.Service.UserLibraryService;

@Component
public class CommandProcessor {

    private final UserLibraryService userLibraryService;

    @Autowired
    public CommandProcessor(UserLibraryService userLibraryService) {
        this.userLibraryService = userLibraryService;
    }

    public void processCommand(String input){
        String[] cmd = input.split(" ");
        switch (cmd[0]){
            case "create_book" -> {
                userLibraryService.createNewBook(new Book(cmd[1], cmd[2], Integer.parseInt(cmd[3]),cmd[4]));
            }
            case "update_book" -> {
                userLibraryService.updateBook(Long.parseLong(cmd[1]), new Book(cmd[1], cmd[2], Integer.parseInt(cmd[3]),cmd[4]));
            }
            case "find_book_by_name" -> {
                userLibraryService.findBookByNameBook(cmd[1]);
            }
            case "delete_book" -> {
                userLibraryService.deleteBook(Long.parseLong(cmd[1]));
            }
            case "find_by_id" -> {
                userLibraryService.findBookById(Long.parseLong(cmd[1]));
            }
            case "show_all_book" -> {
                userLibraryService.showAll();
            }
            default -> {
                System.out.println("Command not found");
            }
        }
    }

}
