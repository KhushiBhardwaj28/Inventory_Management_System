package com.Inv.InventoryMgtSystem.services;

import com.Inv.InventoryMgtSystem.dtos.Response;
import com.Inv.InventoryMgtSystem.dtos.TransactionReqest;
import com.Inv.InventoryMgtSystem.enums.TransactionStatus;

public interface TransactionService {
    Response purchase(TransactionReqest transactionRequest);

    Response sell(TransactionReqest transactionRequest);

    Response returnToSupplier(TransactionReqest transactionRequest);

    Response getAllTransactions(int page, int size, String filter);

    Response getAllTransactionById(Long id);

    Response getAllTransactionByMonthAndYear(int month, int year);

    Response updateTransactionStatus(Long transactionId, TransactionStatus status);
}