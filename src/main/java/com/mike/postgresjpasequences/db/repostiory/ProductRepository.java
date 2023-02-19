package com.mike.postgresjpasequences.db.repostiory;

import com.mike.postgresjpasequences.db.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}

