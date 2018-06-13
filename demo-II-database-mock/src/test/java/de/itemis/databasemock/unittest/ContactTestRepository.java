package de.itemis.databasemock.unittest;

import de.itemis.databasemock.ContactRepository;
import de.itemis.databasemock.model.Contact;

import java.util.List;
import java.util.Optional;

public class ContactTestRepository implements ContactRepository {

    @Override
    public Optional<Contact> findById(String s) {
        Contact contact = new Contact("Peter", "Meyer");
        return Optional.of(contact);
    }

    @Override
    public Contact save(Contact entity) {
        Contact contact = new Contact("Test", "Test");
        contact.setId("10");
        return contact;
    }

    @Override
    public <S extends Contact> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<Contact> findAll() {
        return null;
    }

    @Override
    public Iterable<Contact> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {}

    @Override
    public void delete(Contact entity) {}

    @Override
    public void deleteAll(Iterable<? extends Contact> entities) {}

    @Override
    public void deleteAll() {}

}
