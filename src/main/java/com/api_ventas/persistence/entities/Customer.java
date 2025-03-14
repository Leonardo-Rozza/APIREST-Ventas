package com.api_ventas.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "customer_id")
  private Long id;

  private String name;
  @Column(name = "last_name")
  private String lastName;

  @Column(unique = true )
  private String phone;
  @Column(unique = true )
  private String email;

  private String address;
  private String cp;
  private String city;

  @ManyToOne
  @JoinColumn(name = "country_id")
  @JsonIgnore
  private Country country;

}
