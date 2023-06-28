package org.example;

import org.w3c.dom.Entity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        EntityManager em = Persistence
                .createEntityManagerFactory("hospital")
                .createEntityManager();
    }
}