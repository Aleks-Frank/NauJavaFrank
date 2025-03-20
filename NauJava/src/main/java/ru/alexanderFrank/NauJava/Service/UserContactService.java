package ru.alexanderFrank.NauJava.Service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.alexanderFrank.NauJava.Entity.Contact;
import ru.alexanderFrank.NauJava.Repository.ContactRepository;

import java.util.Optional;

public class UserContactService implements ContactService{

    private final ContactRepository contactRepository;

    @Autowired
    public UserContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public void addNewContact(Contact contact) {
        contactRepository.addContact(contact);
    }

    @Override
    public Optional<Contact> findContactByName(String name) {
        return contactRepository.findContactByName(name);
    }

    @Override
    public Optional<Contact> findContactById(Long id) {
        return contactRepository.findContactById(id);
    }

    @Override
    public Contact updateContact(Long id, Contact contact) {
        return contactRepository.updateContact(id, contact);
    }

    @Override
    public void deleteContactById(Long id) {
        contactRepository.deleteContactById(id);
    }

    @Override
    public void showAll() {
        contactRepository.showAll();
    }
}
