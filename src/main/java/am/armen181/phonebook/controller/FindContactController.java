package am.armen181.phonebook.controller;

import am.armen181.phonebook.dto.ContactDto;
import am.armen181.phonebook.service.FindContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.codec.Utf8;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/api/find")
public class FindContactController {

    private final FindContactService findContactService;

    public FindContactController(FindContactService findContactService) {

        this.findContactService = findContactService;
    }

    @GetMapping(value = "/name/{name}", produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<ContactDto>> get(@PathVariable String name) {
        return ResponseEntity.ok(findContactService.byName(name));
    }

}