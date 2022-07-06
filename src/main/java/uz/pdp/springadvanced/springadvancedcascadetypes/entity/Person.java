package uz.pdp.springadvanced.springadvancedcascadetypes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Data@AllArgsConstructor@NoArgsConstructor
@Entity
    @Where(clause = "date_of_birth is not null")
    public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    private String name;
    private LocalDate dateOfBirth;
    @Transient
    private int age;

    public int getYear() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    @OneToMany(mappedBy = "person", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}) //yoki cascadeType.ALL
    //mappedBy-personda addresses fildi bo'lmaydi, u addressga personni map qiladi. Default holatda dastur 3ta jadval ochsa endi u 2ta jadval ochadi
    //cascade type persist qoyadigan bo'lsak, personni saqlaganimizda addresslar listini ham jsonda bersak u avtomat address repositoryga ularni saqlaydi
    //huddi shunday cascade type MERGE obyektni (midolimizda addressni) update qilishda,
    //REMOVE (misolimizda personni o'chirmoqchi bo'lsak u o'chmaydi negaki u addressga bog'langan
    //agar cascade type REMOVE qiladigan bo'lsak u addressni ham personni ham o'chiradi) ochirishga
    // ALL esa barchasini bajarish mumkin bo'lgan vaqda
    //(cascadeType = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE} bilan teng)) ishlatiladi
    @OrderBy(value = "street asc")
    private List<Address> addresses;
}
