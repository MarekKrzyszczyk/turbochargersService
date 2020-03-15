package com.turbo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "work_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="order_date")
    private LocalDate orderDate;;

    @ManyToOne
    @JoinColumn(name="status_id")
    private Status status;

    @ManyToOne
    @JoinColumn(name="charger_id")
    private Turbocharger turbocharger;

//    @ManyToOne
//    @JoinColumn(name="part_id")
//    private Part part;
//
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="reason_id")
    private Reason reason;
}
