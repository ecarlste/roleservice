package com.erikcarlsten.effectivehabits.roleservice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Role {

    @Id
    @GeneratedValue
    private long id;

    @Getter
    @Setter
    private String name;

    private Role() {}

    public Role(String name) {
        this.name = name;
    }

}
