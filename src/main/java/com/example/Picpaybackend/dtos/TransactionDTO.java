package com.example.Picpaybackend.dtos;

import java.math.BigDecimal;

public record TransactionDTO(BigDecimal value, Long senderId, long receiverId) {
}
