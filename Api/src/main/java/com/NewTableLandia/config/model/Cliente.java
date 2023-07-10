package com.NewTableLandia.config.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany(mappedBy = "clientes")
    private Set<Restaurante> restaurantes = new HashSet<>();

    public Cliente() {
    }

    public Cliente(String nome) {
        this.nome = nome;
    }

    public void adicionarRestaurante(Restaurante restaurante) {
        restaurantes.add(restaurante);
        restaurante.getClientes().add(this);
    }

    public void removerRestaurante(Restaurante restaurante) {
        restaurantes.remove(restaurante);
        restaurante.getClientes().remove(this);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Restaurante> getRestaurantes() {
        return restaurantes;
    }

    public void setRestaurantes(Set<Restaurante> restaurantes) {
        this.restaurantes = restaurantes;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
