package uz.pdp.springadvanced.springadvancedcascadetypes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.springadvanced.springadvancedcascadetypes.entity.Address;
import uz.pdp.springadvanced.springadvancedcascadetypes.entity.Person;
import uz.pdp.springadvanced.springadvancedcascadetypes.payload.AddressDto;
import uz.pdp.springadvanced.springadvancedcascadetypes.payload.PersonDto;
import uz.pdp.springadvanced.springadvancedcascadetypes.repository.AddressRepository;
import uz.pdp.springadvanced.springadvancedcascadetypes.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/address")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private PersonRepository personRepository;

    @PostMapping
    public HttpEntity<?> addPerson(@RequestBody List<AddressDto> addressDto){
        List<Address> addresses = new ArrayList<>();
        addressDto.forEach(addressDto1 -> {
            addresses.add(new Address(addressDto1.getStreet(), personRepository.findById(addressDto1.getPersonId()).get()));
        });
        addressRepository.saveAll(addresses);
        return ResponseEntity.ok("saved");
    }
}
