package org.example;

import entities.WizardDeposit;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("asdf")
                .createEntityManager();

        em.getTransaction().begin();
        WizardDeposit wizardDeposit = new WizardDeposit();
        wizardDeposit.setFirstName("testWizDep");
        wizardDeposit.setAge(100);
        System.out.println(wizardDeposit.getId());
        em.persist(wizardDeposit);
        em.getTransaction().commit();

    }
}