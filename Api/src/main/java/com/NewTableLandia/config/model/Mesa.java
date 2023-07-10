package com.NewTableLandia.config.model;

import jakarta.persistence.*;
import java.util.Collection;
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

    public Mesa() {
    }

    public Mesa(int numero) {
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Set<Restaurante> getRestaurantes() {
        return restaurantes;
    }

    public void setRestaurantes(Set<Restaurante> restaurantes) {
        this.restaurantes = restaurantes;
    }
}
