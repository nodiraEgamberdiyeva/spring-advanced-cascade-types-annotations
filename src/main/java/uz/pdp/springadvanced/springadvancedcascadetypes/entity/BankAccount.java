package uz.pdp.springadvanced.springadvancedcascadetypes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data@AllArgsConstructor@NoArgsConstructor
@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    private String number;

    @OnDelete(action = OnDeleteAction.CASCADE)  //cascadeType.REMOVE bilan bir xil vazifani bajaradi
    @OneToOne (optional = false, fetch = FetchType.LAZY)
    private Client client;

    @Transient      //bu field uchun column ochmaydi
    private long countAccount;
}
