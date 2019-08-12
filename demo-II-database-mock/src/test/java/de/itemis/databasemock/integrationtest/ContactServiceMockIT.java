package de.itemis.databasemock.integrationtest;

import de.itemis.databasemock.Contact;
import de.itemis.databasemock.ContactRepository;
import de.itemis.databasemock.ContactService;
import de.itemis.databasemock.utils.AbstractDbTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ContactServiceMockIT extends AbstractDbTest {

    // A mock is a lot faster than an actual database implementation!
    @MockBean
    ContactRepository repository;

    @Autowired
    ContactService contactService;

    @Test
    void shouldGetFullNameFromStoredContact() {
        when(repository.findById(any())).thenReturn(java.util.Optional.of(new Contact("Peter", "Meyer")));
//        Long id = saveTestContact(repository, "Peter", "Meyer").getId();

        String fullName = contactService.getFullName(0L);

        assertThat(fullName).isEqualTo("Peter Meyer");
    }
}
