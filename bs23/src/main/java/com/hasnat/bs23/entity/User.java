package com.hasnat.bs23.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "username", unique = true)
    private String username;
    private String email;
    private String name;
    private int age;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

}

