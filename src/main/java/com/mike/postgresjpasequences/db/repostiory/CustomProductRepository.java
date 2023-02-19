package com.mike.postgresjpasequences.db.repostiory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.math.BigInteger;

public class CustomProductRepository { //implements ProductRepository {

    @PersistenceContext
    private EntityManager em;

    public BigInteger getNextCustomerNumber(String storeNumber) {

        BigInteger nextNumber = null;

        try {
            Query q = em.createNativeQuery("SELECT NEXT VALUE FOR customer_id_seq_" + storeNumber);
            nextNumber = (BigInteger) q.getSingleResult();
        } catch (RuntimeException runtimeException) {
            try {

                em.createNativeQuery(
                        "create sequence customer_id_seq_" + storeNumber +
                                " start with 10 increment by 1 maxvalue 99999999;").executeUpdate();
                Query q = em.createNativeQuery("SELECT NEXT VALUE FOR customer_id_seq_" + storeNumber);

                nextNumber = (BigInteger) q.getSingleResult();

            } catch (Throwable t) {

                throw t;
            }
        }

        return nextNumber;

    }
}
