package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "owningBank")
    private List<CreditCard> ownedCards = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setOwnedCards(List<CreditCard> ownedCards) {
        this.ownedCards = ownedCards;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<CreditCard> getOwnedCards() {
        return ownedCards;
    }
}
