package com.auth_service.auth_service.config;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@MappedSuperclass
public abstract class BaseEntity {
    @Column(name="status", nullable = false)
    private String status;

    @Column(name="created_at", nullable = false)
    private Date createdAt;
}
