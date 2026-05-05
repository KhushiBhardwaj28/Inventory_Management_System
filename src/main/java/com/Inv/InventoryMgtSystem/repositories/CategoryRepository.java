package com.Inv.InventoryMgtSystem.repositories;

import com.Inv.InventoryMgtSystem.models.Category;
import com.Inv.InventoryMgtSystem.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {



}