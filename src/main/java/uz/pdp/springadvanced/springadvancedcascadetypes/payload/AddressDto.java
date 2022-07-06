package uz.pdp.springadvanced.springadvancedcascadetypes.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data@AllArgsConstructor
public class AddressDto {
    private String street;
    private Long personId;
}
