package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer number;

    private Integer balance;

    private Integer creditLimit;

    @ManyToOne
    private Pincode pincode;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Bank owningBank;

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }

    public void setPincode(Pincode pincode) {
        this.pincode = pincode;
    }

    public void setOwningBank(Bank owningBank) {
        this.owningBank = owningBank;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getBalance() {
        return balance;
    }

    public Integer getCreditLimit() {
        return creditLimit;
    }

    public Pincode getPincode() {
        return pincode;
    }

    public Bank getOwningBank() {
        return owningBank;
    }
}
