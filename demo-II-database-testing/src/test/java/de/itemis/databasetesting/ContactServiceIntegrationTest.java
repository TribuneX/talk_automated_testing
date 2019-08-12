package de.itemis.databasetesting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ContactServiceIntegrationTest {

    @Autowired
    ContactRepository repository;

    @Autowired
    ContactService contactService;

    @Test
    void shouldLoadFullName() {
        Long id = saveTestContact(repository, "Peter", "Meyer").getId();

        String fullName = contactService.getFullName(id);

        assertThat(fullName).isEqualTo("Peter Meyer");
    }

    protected Contact saveTestContact(ContactRepository repository, String firstName, String lastName) {
        Contact contact = new Contact(firstName, lastName);
        return repository.save(contact);
    }
}
