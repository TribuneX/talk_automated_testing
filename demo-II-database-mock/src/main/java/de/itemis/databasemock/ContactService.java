package de.itemis.databasemock;

public class ContactService {

    private ContactRepository repository;

    public ContactService(ContactRepository repository) {
        this.repository = repository;
    }

    public String getFullName(Long id) {
        Contact contact = repository.findById(id).get();
        return contact.getFirstName() + " " + contact.getLastName();
    }
}
