package com.Inv.InventoryMgtSystem.repositories;

import com.Inv.InventoryMgtSystem.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TransactionRepository extends JpaRepository<Transaction, Long>, JpaSpecificationExecutor<Transaction> {

	long countByProduct_Id(Long productId);

	@Modifying
	@Transactional
	@Query("UPDATE Transaction t SET t.product = null WHERE t.product.id = :productId")
	int clearProductReferences(Long productId);

}