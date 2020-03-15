package com.turbo.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column(name="last_name")
    private String lastName;

    @Column
    private String telephone;

    @Column
    private String email;

    @Column(name="company_name")
    private String companyName;

    @Column
    private String nip;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

}
