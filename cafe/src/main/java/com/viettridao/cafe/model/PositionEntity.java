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
@Table(name = "positions")//chucvu
public class PositionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Integer id;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "position_name")
    private String positionName;

    @Column(name = "is_deleted")
    private Boolean deleted;

    @OneToMany(mappedBy = "position")
    private List<EmployeeEntity> employees;
}
