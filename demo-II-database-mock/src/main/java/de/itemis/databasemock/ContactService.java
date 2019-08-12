package de.itemis.databasemock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactRepository repository;

    public String getFullName(Long id) {
        Contact contact = repository.findById(id).get();
        return contact.getFirstName() + " " + contact.getLastName();
    }
}
