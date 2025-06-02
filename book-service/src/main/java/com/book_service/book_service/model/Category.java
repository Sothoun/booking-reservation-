package com.book_service.book_service.model;

import com.book_service.book_service.config.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Base64;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name="tbl_category")
public class Category extends BaseEntity {
    @Id
    private String id;
    @NotBlank
    private String name;
    @Column(name="description", nullable = true)
    private String description;
}
