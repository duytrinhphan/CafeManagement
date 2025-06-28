package com.viettridao.cafe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "imports")//donnhap
public class ImportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "imports_id")
    private Integer id;

    @Column(name = "import_date")
    private LocalDate importDate;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "is_deleted")
    private Boolean deleted;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private ProductEntity product;
}
