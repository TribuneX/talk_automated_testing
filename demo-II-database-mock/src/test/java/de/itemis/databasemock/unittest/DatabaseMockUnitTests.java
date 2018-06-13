package de.itemis.databasemock.unittest;


import de.itemis.databasemock.ContactService;
import de.itemis.databasemock.utils.AbstractDbTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DatabaseMockUnitTests extends AbstractDbTest {

    @BeforeEach
    public void setUp() {
        this.repository = new ContactTestRepository();
        this.contactService = new ContactService(repository);
    }

    @Test
    public void canLoadFullName() {
        String id = saveTestContact(repository, "Peter", "Meyer").getId();

        String fullName = contactService.getFullName(id);

        assertThat(fullName).isEqualTo("Peter Meyer");
    }
}
