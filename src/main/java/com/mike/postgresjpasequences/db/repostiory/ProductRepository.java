package com.mike.postgresjpasequences.db.repostiory;

import com.mike.postgresjpasequences.db.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {


    String createSequenceSql =  "CREATE sequence devschema.customer_id_seq_99 start with " +
            "10 increment by 1 maxvalue 99999999";
    @Modifying
    @Query(value = createSequenceSql, nativeQuery = true)
    void createSequenceForStore( Long storeNumber);

    String selectNextValueFromSequenceSql =  "select nextval('devschema.customer_id_seq_99')";

    @Query(value = selectNextValueFromSequenceSql, nativeQuery = true)
    Long getNextSequenceValueForStore(Long storeNumber);


}

