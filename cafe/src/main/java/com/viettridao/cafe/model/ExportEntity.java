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
@Table(name = "exports")//donxuat
public class ExportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exports_id")
    private Integer id;

    @Column(name = "total_export_amount")
    private Double totalExportAmount;

    @Column(name = "export_date")
    private LocalDate exportDate;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "is_deleted")
    private Boolean deleted;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private ProductEntity product;
}
