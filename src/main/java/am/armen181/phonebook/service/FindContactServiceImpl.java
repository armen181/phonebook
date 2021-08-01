package am.armen181.phonebook.service;

import am.armen181.phonebook.dto.ContactDto;
import am.armen181.phonebook.entity.Contact;
import am.armen181.phonebook.repository.ContactRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindContactServiceImpl implements FindContactService {

    private final ContactRepository contactRepository;

    public FindContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<ContactDto> byName(final String name) {
        if(name.length() < 3) {
            return Collections.emptyList();
        }
        final List<Contact> allByName = contactRepository.findAllByNameContainingIgnoreCase(name.trim());
        return allByName.stream().map(contact -> {
            final ContactDto dto = new ContactDto();
            BeanUtils.copyProperties(contact, dto);
            return dto;
        }).collect(Collectors.toList());
    }
}
