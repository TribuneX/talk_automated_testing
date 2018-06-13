package de.itemis.databasemock;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Contact {

    @Id
    private String id;
    private final String firstName;
    private final String lastName;
}