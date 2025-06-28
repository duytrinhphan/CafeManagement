package com.viettridao.cafe.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ReservationKey {
    @Column(name = "table_id")
    private Integer idTable;

    @Column(name = "employee_id")
    private Integer idEmployee;

    @Column(name = "invoice_id")
    private Integer idInvoice;
}
