package am.armen181.phonebook.service;

import am.armen181.phonebook.dto.ContactDto;
import am.armen181.phonebook.entity.Contact;

import java.util.List;

public interface ContactService {
    void create(ContactDto dto);
    void edit(Long id, ContactDto dto);
    void delete(Long id);
    List<Contact> get(String name);
}
