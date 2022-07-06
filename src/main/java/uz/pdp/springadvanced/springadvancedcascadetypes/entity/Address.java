package uz.pdp.springadvanced.springadvancedcascadetypes.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data@AllArgsConstructor@NoArgsConstructor
@Entity
@JsonIgnoreProperties(value = {"person", "street"})
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    private String street;

//    @JsonIgnore
    //rekursiyaga tushib qolishdan saqlaydi
    @ManyToOne(optional = false, fetch = FetchType.LAZY) //fetchType.Lazy qachonki address tableda person chaqirilsagina uni olib keladi
    private Person person;

    public Address(String street, Person person) {
        this.street = street;
        this.person = person;
    }
}
