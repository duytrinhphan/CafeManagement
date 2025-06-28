package com.viettridao.cafe.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "units")//donvitinh
public class UnitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unit_id")
    private Integer id;

    @Column(name = "unit_name")
    private String unitName;

    @Column(name = "is_deleted")
    private Boolean deleted;

    @OneToMany(mappedBy = "unit", cascade = CascadeType.ALL)
    private List<ProductEntity> products;
}
