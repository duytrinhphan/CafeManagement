package com.viettridao.cafe.model;

import com.viettridao.cafe.common.TableStatus;
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
@Table(name = "tables")//ban
public class TableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TableStatus status;

    @Column(name = "table_name")
    private String tableName;

    @Column(name = "is_deleted")
    private Boolean deleted;

    @OneToMany(mappedBy = "table", cascade = CascadeType.ALL)
    private List<ReservationEntity> reservations;
}
