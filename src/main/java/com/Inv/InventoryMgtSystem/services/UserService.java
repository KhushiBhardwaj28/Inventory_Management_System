package com.Inv.InventoryMgtSystem.services;

import com.Inv.InventoryMgtSystem.dtos.LoginRequest;
import com.Inv.InventoryMgtSystem.dtos.RegisterRequest;
import com.Inv.InventoryMgtSystem.dtos.Response;
import com.Inv.InventoryMgtSystem.dtos.UserDTO;
import com.Inv.InventoryMgtSystem.models.User;

public interface UserService {
    Response registerUser(RegisterRequest registerRequest);

    Response loginUser(LoginRequest loginRequest);

    Response getAllUsers();

    User getCurrentLoggedInUser();

    Response getUserById(Long id);

    Response updateUser(Long id, UserDTO userDTO);

    Response deleteUser(Long id);

    Response getUserTransactions(Long id);
}