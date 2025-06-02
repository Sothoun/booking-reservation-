package com.auth_service.auth_service.model;


import com.auth_service.auth_service.config.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Getter
@Setter
@Table(name="tbl_user")
public abstract class User extends BaseEntity {
    @Id
    private String id;
    @Column(name="password", nullable=false, unique = true)
    private String password;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name="photo", nullable = true)
    private String photo;
    @Column(name="phone", nullable = true)
    private String phone;
    @Column(name="email", nullable = false)
    private String email;
}
