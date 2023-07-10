package com.NewTableLandia.config.dto;

public class MesaDTO {
    private Long id;
    private int numero;

    public MesaDTO() {
    }

    public MesaDTO(Long id, int numero) {
        this.id = id;
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
}
