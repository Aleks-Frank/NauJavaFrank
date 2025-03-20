package ru.alexanderFrank.NauJava.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.alexanderFrank.NauJava.Entity.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ContactRepositoryIMPL implements ContactRepository{

    private final List<Contact> listContacts;

    @Autowired
    public ContactRepositoryIMPL(List<Contact> listContacts) {
        this.listContacts = listContacts;
    }

    @Override
    public void addContact(Contact contact) {
        listContacts.add(contact);
    }

    @Override
    public Optional<Contact> findContactByName(String name) {
        return listContacts.stream()
                .filter(t -> t.getName().equals(name))
                .findAny();
    }

    @Override
    public Optional<Contact> findContactById(Long id) {
        return listContacts.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }

    @Override
    public Contact updateContact(Long id, Contact contact) {
        Contact updateInfo = findContactById(id).orElse(null);
        if (updateInfo != null){
            updateInfo.setName(contact.getName());
            updateInfo.setPhone(contact.getPhone());
        }
        return updateInfo;
    }

    @Override
    public void deleteContactById(Long id) {
        findContactById(id).ifPresent(listContacts::remove);
    }

    @Override
    public void showAll() {
        for(Contact contact : listContacts){
            System.out.println(contact.toString());
        }
    }
}
