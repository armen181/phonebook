package am.armen181.phonebook.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Contact extends BaseEntity{

    private String name;

    private String surname;

    private String email;

    private String phoneNumber;

    private String mobileNumber;

}
