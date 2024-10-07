package com.example.Picpaybackend.domain.user;


import com.example.Picpaybackend.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String FirstName;
    private String LastName;
    @Column(unique = true)
    private String document;
    @Column(unique = true)
    private String email;
    private String password;
    private BigDecimal balance;
    @Enumerated(EnumType.STRING)
    private Usertype usertype;


    public User(UserDTO data){
        this.FirstName = data.firstName();
        this.LastName = data.lastName();
        this.password = data.password();
        this.document = data.document();
        this.email = data.email();
        this.usertype = data.usertype();
        this.balance = data.balance();


    }

}
