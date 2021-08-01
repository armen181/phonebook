package am.armen181.phonebook.service;

import am.armen181.phonebook.dto.ContactDto;

import java.util.List;

public interface FindContactService {
    public List<ContactDto> byName(final String name);
}
