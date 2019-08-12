package de.itemis.databasemock.unittest;

import de.itemis.databasemock.ContactRepository;
import de.itemis.databasemock.ContactService;
import de.itemis.databasemock.utils.AbstractDbTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ContactServiceEvenFasterTest extends AbstractDbTest {

    ContactRepository repository;

    ContactService contactService;

    @BeforeEach
    void setUp() {
        repository = new ContactTestRepository();
        contactService = new ContactService(repository);
    }

    @Test
    void shouldGetFullNameFromStoredContact() {
        Long id = saveTestContact(repository, "Peter", "Meyer").getId();

        String fullName = contactService.getFullName(0L);

        assertThat(fullName).isEqualTo("Peter Meyer");
    }
}
