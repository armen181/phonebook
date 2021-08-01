package am.armen181.phonebook.repository;

import am.armen181.phonebook.entity.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ContactRepository extends CrudRepository<Contact, Long> {

    List<Contact> findAllByNameContainingIgnoreCase(String name);
}