package com.example.jpademo.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name = "BOOKS")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false)
  private Long id;

  @Column(name = "TITLE", nullable = false)
  private String title;

  @Column(name = "AUTHOR", nullable = false)
  private String author;

  @Column(name = "PUBLISHED_YEAR", nullable = false)
  private Integer publishedYear;

}
