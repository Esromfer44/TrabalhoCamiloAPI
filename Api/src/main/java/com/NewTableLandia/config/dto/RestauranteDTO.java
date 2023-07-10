package com.NewTableLandia.config.dto;

public class RestauranteDTO {

    private Long id;
    private String nome;
    private String endereco;
    private String tipoCozinha;
    private int capacidadeMesas;

    public RestauranteDTO() {
    }

    public RestauranteDTO(Long id, String nome, String endereco, String tipoCozinha, int capacidadeMesas) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.tipoCozinha = tipoCozinha;
        this.capacidadeMesas = capacidadeMesas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipoCozinha() {
        return tipoCozinha;
    }

    public void setTipoCozinha(String tipoCozinha) {
        this.tipoCozinha = tipoCozinha;
    }

    public int getCapacidadeMesas() {
        return capacidadeMesas;
    }

    public void setCapacidadeMesas(int capacidadeMesas) {
        this.capacidadeMesas = capacidadeMesas;
    }
}
