package com.book_service.book_service.model;

import com.book_service.book_service.config.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name="tbl-book")
public class Book extends BaseEntity {
    @Id
    private String id;
    @NotBlank
    private String title;
    @Column(name="category_id", nullable = false)
    private String categoryId;
    private String author;
    @Column(name="description", nullable = true)
    private String Description;
}
