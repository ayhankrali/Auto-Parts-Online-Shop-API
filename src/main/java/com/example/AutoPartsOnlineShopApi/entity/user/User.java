package com.example.AutoPartsOnlineShopApi.entity.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    @Column(name = "password")
    private String password;

    // For simplicity, using a role-based system with a single role for now
    @NotNull
    @Column(name = "role")
    private String role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }


    public User(String testUser, String testPassword) {
        this.username = testUser;
        this.password = testPassword;
        this.role = "ROLE_USER";
    }
}
