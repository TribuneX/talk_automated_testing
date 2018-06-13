package de.itemis.databasemock.utils;

import de.itemis.databasemock.ContactRepository;
import de.itemis.databasemock.ContactService;
import de.itemis.databasemock.model.Contact;

public abstract class AbstractDbTest {

    protected ContactRepository repository;
    protected ContactService contactService;

    protected Contact saveTestContact(ContactRepository repository, String firstName, String lastName) {
        Contact contact = new Contact(firstName, lastName);
        return repository.save(contact);
    }

}
