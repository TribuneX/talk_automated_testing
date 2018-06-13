package de.itemis.databasemock;

import de.itemis.databasemock.model.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, String> {
}
