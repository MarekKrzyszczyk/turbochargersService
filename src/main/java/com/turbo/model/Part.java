package com.turbo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "part")
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="part_order",
            joinColumns = @JoinColumn(name="part_id"),
            inverseJoinColumns = @JoinColumn(name="order_id")
    )
    private List<Order> orders;
}
