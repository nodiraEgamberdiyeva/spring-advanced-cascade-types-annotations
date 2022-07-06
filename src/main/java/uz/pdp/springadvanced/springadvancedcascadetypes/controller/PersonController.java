package uz.pdp.springadvanced.springadvancedcascadetypes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springadvanced.springadvancedcascadetypes.entity.Address;
import uz.pdp.springadvanced.springadvancedcascadetypes.entity.Person;
import uz.pdp.springadvanced.springadvancedcascadetypes.payload.PersonDto;
import uz.pdp.springadvanced.springadvancedcascadetypes.repository.PersonRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Transactional(dontRollbackOn = {NullPointerException.class, NegativeArraySizeException.class},
    rollbackOn = EnumConstantNotPresentException.class)
    //agar methodda exception tashisa barcha db bilan bo'lgan transaksiyalarni orqaga qaytaradi
    @PostMapping
    public HttpEntity<?> addPerson(@RequestBody PersonDto personDto){
        Person person = new Person();
        person.setName(personDto.getName());
        person.setDateOfBirth(personDto.getDateOfBirth());
        List<Address> addresses = new ArrayList<>();
        personDto.getAddresses().forEach(address -> {
            addresses.add(new Address(address.getStreet(), person));
        });
        person.setAddresses(addresses);
        personRepository.save(person);
        return ResponseEntity.ok("saved");
    }

    @GetMapping
    public HttpEntity<?> getAllPerson(){
        return ResponseEntity.ok(personRepository.findAll());
    }
}
