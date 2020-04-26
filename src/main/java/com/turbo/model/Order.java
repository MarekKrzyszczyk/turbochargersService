package com.turbo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "work_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "charger_id")
    private Turbocharger turbocharger;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "part_order",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "part_id")
    )
    private List<Part> parts;

//    @ManyToOne
//    @JoinColumn(name = "part_id")
//    private Part parts;

    @ManyToOne
    @JoinColumn(name = "reason_id")
    private Reason reason;

    public Order(Turbocharger turbocharger, List<Part> parts, Reason reason) {
        this.turbocharger = turbocharger;
        this.parts = parts;
        this.reason = reason;
    }

    public Order() {
    }
}
