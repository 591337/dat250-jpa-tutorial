package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.*;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
    }

  }

  private static void createObjects(EntityManager em) {
    Pincode pincode = new Pincode();
    pincode.setCode("123");
    pincode.setCount(1);

    em.persist(pincode);

    Bank bank = new Bank();
    bank.setName("Pengebank");

    em.persist(bank);

    CreditCard cc1 = new CreditCard();
    cc1.setCreditLimit(-10_000);
    cc1.setBalance(-5_000);
    cc1.setNumber(12345);
    cc1.setPincode(pincode);
    cc1.setOwningBank(bank);

    em.persist(cc1);

    CreditCard cc2 = new CreditCard();
    cc2.setCreditLimit(2000);
    cc2.setBalance(1);
    cc2.setNumber(123);
    cc2.setPincode(pincode);
    cc2.setOwningBank(bank);

    em.persist(cc2);

    Address address = new Address();
    address.setNumber(28);
    address.setStreet("Inndalsveien");

    em.persist(address);

    Customer customer = new Customer();
    customer.setName("Max Mustermann");
    customer.getAddresses().add(address);
    customer.getCreditCards().add(cc1);
    customer.getCreditCards().add(cc2);

    em.persist(customer);
  }
}
