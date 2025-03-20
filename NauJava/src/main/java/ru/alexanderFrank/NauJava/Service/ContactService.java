package ru.alexanderFrank.NauJava.Service;

import ru.alexanderFrank.NauJava.Entity.Contact;

import java.util.Optional;

public interface ContactService {

    void addNewContact(Contact contact);

    Optional<Contact> findContactByName(String name);

    Optional<Contact> findContactById(Long id);

    Contact updateContact(Long id, Contact contact);

    void deleteContactById(Long id);

    void showAll();

}
