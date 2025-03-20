package ru.alexanderFrank.NauJava.Repository;

import ru.alexanderFrank.NauJava.Entity.Contact;

import java.util.Optional;

public interface ContactRepository {

    void addContact(Contact contact);

    Optional<Contact> findContactByName(String name);

    Optional<Contact> findContactById(Long id);

    Contact updateContact(Long id, Contact contact);

    void deleteContactById(Long id);

    void showAll();

}
