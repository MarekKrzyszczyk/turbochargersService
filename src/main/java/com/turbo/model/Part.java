package com.turbo.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "turboparts")
public class TurboPart {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name="inc", strategy = "increment")
    private Integer id;

    @Column
    private String description;
}
