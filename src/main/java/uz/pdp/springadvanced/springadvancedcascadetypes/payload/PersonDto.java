package uz.pdp.springadvanced.springadvancedcascadetypes.payload;

import lombok.Data;
import uz.pdp.springadvanced.springadvancedcascadetypes.entity.Address;

import java.time.LocalDate;
import java.util.List;

@Data
public class PersonDto {
    private String name;
    private List<Address> addresses;
    private LocalDate dateOfBirth;
}
