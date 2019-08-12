package de.itemis.databasemock.unittest;

import de.itemis.databasemock.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class ContactTestRepository<S> implements de.itemis.databasemock.ContactRepository {

    private List<Contact> repository = new ArrayList<>();

    @Override
    public <S extends Contact> S save(final S s) {
        s.setId(new Random().nextLong());
        repository.add(s);
        return s;
    }

    @Override
    public <S extends Contact> Iterable<S> saveAll(final Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Contact> findById(final Long aLong) {
        return Optional.of(repository.get(0));
    }

    @Override
    public boolean existsById(final Long aLong) {
        return false;
    }

    @Override
    public Iterable<Contact> findAll() {
        return null;
    }

    @Override
    public Iterable<Contact> findAllById(final Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(final Long aLong) {

    }

    @Override
    public void delete(final Contact contact) {

    }

    @Override
    public void deleteAll(final Iterable<? extends Contact> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
