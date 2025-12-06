package com.Inv.InventoryMgtSystem.services;

import com.Inv.InventoryMgtSystem.dtos.CategoryDTO;
import com.Inv.InventoryMgtSystem.dtos.Response;

public interface CategoryService {

    Response createCategory(CategoryDTO categoryDTO);

    Response getAllCategories();

    Response getCategoryById(Long id);

    Response updateCategory(Long id, CategoryDTO categoryDTO);

    Response deleteCategory(Long id);
}