package de.itemis.databasemock.unittest;

import de.itemis.databasemock.Contact;
import de.itemis.databasemock.ContactRepository;
import de.itemis.databasemock.ContactService;
import de.itemis.databasemock.utils.AbstractDbTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ContactServiceFasterTest extends AbstractDbTest {

    ContactRepository repository;

    ContactService contactService;

    @BeforeEach
    void setUp() {
        repository = Mockito.mock(ContactRepository.class);
        contactService = new ContactService(repository);
    }

    @Test
    void shouldGetFullNameFromStoredContact() {
        when(repository.findById(any())).thenReturn(java.util.Optional.of(new Contact("Peter", "Meyer")));
//        Long id = saveTestContact(repository, "Peter", "Meyer").getId();

        String fullName = contactService.getFullName(0L);

        assertThat(fullName).isEqualTo("Peter Meyer");
    }
}
