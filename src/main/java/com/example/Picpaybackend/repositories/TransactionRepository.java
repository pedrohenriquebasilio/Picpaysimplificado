package com.example.Picpaybackend.repositories;

import com.example.Picpaybackend.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
