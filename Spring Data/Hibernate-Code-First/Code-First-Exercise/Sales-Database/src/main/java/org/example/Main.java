package org.example;

import entities.StoreLocation;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        EntityManager entityManager = Persistence
                .createEntityManagerFactory("sales")
                .createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();

    }
}