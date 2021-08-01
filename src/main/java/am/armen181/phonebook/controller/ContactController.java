package am.armen181.phonebook.controller;

import am.armen181.phonebook.dto.ContactDto;
import am.armen181.phonebook.service.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody ContactDto dto) {
        contactService.create(dto);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        contactService.delete(id);
        return ResponseEntity.accepted().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> delete(@RequestBody ContactDto dto, @PathVariable Long id) {
        contactService.edit(id, dto);
        return ResponseEntity.accepted().build();
    }

    @GetMapping(value = "/name/{name}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> get(@PathVariable String name) {
        return ResponseEntity.ok(contactService.get(name));
    }

}
