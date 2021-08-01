package am.armen181.phonebook.service;

import am.armen181.phonebook.dto.ContactDto;
import am.armen181.phonebook.entity.Contact;
import am.armen181.phonebook.repository.ContactRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public void create(ContactDto dto) {
        final Contact contact = new Contact();
        BeanUtils.copyProperties(dto, contact);
        contactRepository.save(contact);
    }

    public void edit(Long id, ContactDto dto) {
        final Contact oldContact = contactRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Cannot find Contact with id %d", id)));
        final Contact contact = new Contact();
        BeanUtils.copyProperties(dto, contact);
        contact.setId(oldContact.getId());
        contact.setCreatedAt(oldContact.getCreatedAt());
        contactRepository.save(contact);
    }


    public void delete(Long id) {
        final Contact oldContact = contactRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Cannot find Contact with id %d", id)));
        contactRepository.delete(oldContact);
    }

    public List<Contact> get(String name) {
       return contactRepository.findAllByNameContainingIgnoreCase(name);
    }
}
