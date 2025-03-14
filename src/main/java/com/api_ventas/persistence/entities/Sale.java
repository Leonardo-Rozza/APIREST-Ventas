package com.api_ventas.persistence.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sales")
public class Sale {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "sale_id")
  private Long id;

  private LocalDate date;
  private BigDecimal total;

  @ManyToOne
  @JoinColumn(name = "customer_id")
  @JsonIgnore
  private Customer customer;

  @OneToMany(mappedBy = "sale" ,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JsonIgnore
  private List<ProductForSale> productForSaleLists;

}
