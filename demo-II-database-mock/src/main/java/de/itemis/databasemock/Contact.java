package de.itemis.databasemock;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Contact {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;

    public Contact(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
