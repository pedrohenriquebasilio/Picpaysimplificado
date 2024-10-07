package com.example.Picpaybackend.dtos;

import com.example.Picpaybackend.domain.user.Usertype;

import java.math.BigDecimal;

public record UserDTO(String firstName, String lastName, String document, BigDecimal balance, String email, String password, Usertype usertype) {
}
