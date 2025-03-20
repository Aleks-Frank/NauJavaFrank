package ru.alexanderFrank.NauJava.CommandProcessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.alexanderFrank.NauJava.Entity.Contact;
import ru.alexanderFrank.NauJava.Service.UserContactService;

@Component
public class CommandProcessor {

    private final UserContactService userContactService;

    @Autowired
    public CommandProcessor(UserContactService userContactService) {
        this.userContactService = userContactService;
    }

    public void processCommand(String input){
        String[] cmd = input.split(" ");
        switch (cmd[0]){
            case "add" -> {
                userContactService.addNewContact(new Contact(Long.valueOf(cmd[1]),cmd[2],cmd[3]));
            }
            case "show" -> {
                userContactService.showAll();
            }
            case "update" -> {
                userContactService.updateContact(Long.valueOf(cmd[1]), new Contact(Long.valueOf(cmd[1]),cmd[2],cmd[3]));
            }
            case "findId" -> {
                System.out.println(userContactService.findContactById(Long.valueOf(cmd[1])));
            }
            case "findName" -> {
                System.out.println(userContactService.findContactByName(cmd[1]));
            }
            case "delete" -> {
                userContactService.deleteContactById(Long.valueOf(cmd[1]));
            }
            default -> System.out.println("Введена неизвестная команда...");
        }
    }
}
