package com.viettridao.cafe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")//hanghoa
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Double price;

    @Column(name = "is_deleted")
    private Boolean deleted;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ImportEntity> imports;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ExportEntity> exports;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<MenuDetailEntity> menuDetails;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "unit_id")
    private UnitEntity unit;
}
