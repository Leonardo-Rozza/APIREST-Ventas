package com.api_ventas.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "countries")
public class Country {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "country_id")
  private Long id;

  @Column(nullable = false, unique = true)
  private String name;
  @Column(nullable = false, unique = true)
  private String domain;

}
