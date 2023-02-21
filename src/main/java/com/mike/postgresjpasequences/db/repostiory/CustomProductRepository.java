package com.mike.postgresjpasequences.db.repostiory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CustomProductRepository { //implements ProductRepository {

    @PersistenceContext
    private EntityManager em;

    public Long getNextProductId(Long storeNumber) {

        Long nextNumber = null;

        try {
            Query getNextCustomerSequence = em.createNativeQuery("SELECT nextval(\'devschema.customer_id_seq_" + storeNumber + "\')");
            nextNumber = (Long) getNextCustomerSequence.getSingleResult();
        } catch (RuntimeException runtimeException) {
            try {

                var createSequence = "create sequence devschema.customer_id_seq_" + storeNumber +
                        " start 10 increment 1 minvalue 1";
                em.createNativeQuery(createSequence).executeUpdate();

                Query q2 = em.createNativeQuery("SELECT nextval(\'devschema.customer_id_seq_" + storeNumber + "\')");

                nextNumber = (Long) q2.getSingleResult();

            } catch (Throwable t) {

                throw t;
            }
        }

        return nextNumber;

    }
}
