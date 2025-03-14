package com.api_ventas.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "product_for_sale")
public class ProductForSale {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "product_for_sale_id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "product_id")
  @JsonIgnore
  private Product product;

  @ManyToOne
  @JoinColumn(name = "sale_id")
  @JsonIgnore
  private Sale sale;

  private int quantity;
}
