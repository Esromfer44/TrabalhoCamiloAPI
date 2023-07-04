package com.NewTableLandia.Api.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "mesa")
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numero;

    @ManyToMany(mappedBy = "mesas")
    private Set<Restaurante> restaurantes = new HashSet<>();

    public Collection<Restaurante> getRestaurantes() {
        return Collections.unmodifiableSet(restaurantes);
    }

}
