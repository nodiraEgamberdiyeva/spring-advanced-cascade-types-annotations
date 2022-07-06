package uz.pdp.springadvanced.springadvancedcascadetypes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.print.CancelablePrintJob;

@Data@AllArgsConstructor@NoArgsConstructor
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    private String name;
    @OneToOne(mappedBy = "client", cascade = CascadeType.PERSIST)
    private BankAccount bankAccount;

    public void setBankAccount(BankAccount bankAccount) {
        bankAccount.setClient(this);
        this.bankAccount = bankAccount;
    }
}
