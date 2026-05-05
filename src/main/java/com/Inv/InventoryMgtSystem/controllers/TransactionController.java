package com.Inv.InventoryMgtSystem.controllers;

import com.Inv.InventoryMgtSystem.dtos.Response;
import com.Inv.InventoryMgtSystem.dtos.TransactionReqest;
import com.Inv.InventoryMgtSystem.enums.TransactionStatus;
import com.Inv.InventoryMgtSystem.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

	private final TransactionService transactionService;

	@PostMapping("/purchase")
	public ResponseEntity<Response> purchase(@RequestBody TransactionReqest request) {
		return ResponseEntity.ok(transactionService.purchase(request));
	}

	@PostMapping("/sell")
	public ResponseEntity<Response> sell(@RequestBody TransactionReqest request) {
		return ResponseEntity.ok(transactionService.sell(request));
	}

	@PostMapping("/return")
	public ResponseEntity<Response> returnToSupplier(@RequestBody TransactionReqest request) {
		return ResponseEntity.ok(transactionService.returnToSupplier(request));
	}

	@GetMapping("/all")
	public ResponseEntity<Response> getAll(@RequestParam(value = "filter", required = false) String filter) {
		// Return all with a large page size; client paginates
		return ResponseEntity.ok(transactionService.getAllTransactions(0, Integer.MAX_VALUE, filter));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Response> getById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(transactionService.getAllTransactionById(id));
	}

	@GetMapping("/by-month-year")
	public ResponseEntity<Response> getByMonthYear(@RequestParam("month") int month,
												   @RequestParam("year") int year) {
		return ResponseEntity.ok(transactionService.getAllTransactionByMonthAndYear(month, year));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Response> updateStatus(@PathVariable("id") Long id,
												 @RequestBody TransactionStatus status) {
		return ResponseEntity.ok(transactionService.updateTransactionStatus(id, status));
	}
}
