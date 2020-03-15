package com.turbo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "turbocharger")
public class Turbocharger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String number;

    @Column
    private String model;

    @Column
    private String producer;

    @OneToMany(mappedBy = "turbocharger")
    private List<Order> orders;
}
