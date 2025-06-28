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
@Table(name = "table_reservations_detail")//chitietdatban
public class ReservationEntity {
    @EmbeddedId
    private ReservationKey id;

    @ManyToOne
    @MapsId("idTable")
    @JoinColumn(name = "table_id")
    private TableEntity table;

    @ManyToOne
    @MapsId("idEmployee")
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;

    @ManyToOne
    @MapsId("idInvoice")
    @JoinColumn(name = "invoice_id")
    private InvoiceEntity invoice;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_phone_number")
    private String customerPhone;

    @Column(name = "reservation_datetime")
    private LocalDate reservationDate;

    @Column(name = "is_deleted")
    private Boolean deleted;
}
