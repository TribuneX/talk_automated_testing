package de.itemis.databasemock;

import de.itemis.databasemock.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private final ContactRepository repository;

    @Autowired
    public ContactService(ContactRepository repository) {
        this.repository = repository;
    }

    public String getFullName(String id) {
        Contact contact = repository.findById(id).get();
        return contact.getFirstName() + " " + contact.getLastName();
    }
}
