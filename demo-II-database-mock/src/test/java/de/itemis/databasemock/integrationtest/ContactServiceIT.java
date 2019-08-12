package de.itemis.databasemock.integrationtest;

import de.itemis.databasemock.ContactRepository;
import de.itemis.databasemock.ContactService;
import de.itemis.databasemock.utils.AbstractDbTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ContactServiceIT extends AbstractDbTest {

    @Autowired
    ContactRepository repository;

    @Autowired
    ContactService contactService;

    @Test
    void canLoadFullName() {
        Long id = saveTestContact(repository, "Peter", "Meyer").getId();

        String fullName = contactService.getFullName(id);

        assertThat(fullName).isEqualTo("Peter Meyer");
    }
}
