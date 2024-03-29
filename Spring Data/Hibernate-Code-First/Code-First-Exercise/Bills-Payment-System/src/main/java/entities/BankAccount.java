package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bank_accounts")
public class BankAccount extends BillingDetails {

    @Column(name = "bank_name", length = 50)
    private String bankName;

    @Column(name = "SWIFT_code", length = 50)
    private String swiftCode;
}
