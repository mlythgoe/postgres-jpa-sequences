package com.mike.postgresjpasequences.db.repostiory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class CustomProductRepository { //implements ProductRepository {

    @PersistenceContext
    private EntityManager em;

//    @Modifying
//    @Transactional()
//    public Long getNextProductId(Long storeNumber) {
//
//        Long nextNumber = null;
//
//        var getSequenceSql = "SELECT NEXTVAL('devschema.customer_id_seq_" + storeNumber + "')";
//
//        try {
//            Query q = em.createNativeQuery(getSequenceSql);
//            nextNumber = (Long) q.getSingleResult();
//        } catch (RuntimeException runtimeException) {
//            try {
//
//                var createSequenceSql = "create sequence devschema.customer_id_seq_" + storeNumber +
//                        " start with 10 increment by 1 maxvalue 99999999";
//                em.createNativeQuery(createSequenceSql).executeUpdate();
//
//                Query q = em.createNativeQuery(getSequenceSql);
//
//                nextNumber = (Long) q.getSingleResult();
//
//            } catch (Throwable t) {
//
//                throw t;
//            }
//
//        }
//
//        return nextNumber;
//
//    }
}
