package com.Inv.InventoryMgtSystem.repositories;

import com.Inv.InventoryMgtSystem.models.Category;
import com.Inv.InventoryMgtSystem.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TransactionRepository extends JpaRepository<Transaction, Long>, JpaSpecificationExecutor<Transaction> {



}