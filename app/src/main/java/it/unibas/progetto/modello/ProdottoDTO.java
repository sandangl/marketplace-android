package it.unibas.progetto.modello;

import org.jetbrains.annotations.NotNull;

public class ProdottoDTO {
    private Long id;
    private String descrizione;
    private String marca;
    private String categoria;
    private double prezzo;

    public ProdottoDTO() {
    }

    public ProdottoDTO(Long id, String descrizione, String marca, String categoria, double prezzo) {
        this.id = id;
        this.descrizione = descrizione;
        this.marca = marca;
        this.categoria = categoria;
        this.prezzo = prezzo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
}
