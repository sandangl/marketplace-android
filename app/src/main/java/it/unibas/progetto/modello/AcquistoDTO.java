package it.unibas.progetto.modello;

import org.jetbrains.annotations.NotNull;

public class AcquistoDTO {
    private int quantita;
    private Long idOrdine;
    private Long idProdotto;

    public AcquistoDTO() {
    }

    public AcquistoDTO(int quantita, Long idOrdine, Long idProdotto) {
        this.quantita = quantita;
        this.idOrdine = idOrdine;
        this.idProdotto = idProdotto;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public Long getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(Long idOrdine) {
        this.idOrdine = idOrdine;
    }

    public Long getIdProdotto() {
        return idProdotto;
    }

    public void setIdProdotto(Long idProdotto) {
        this.idProdotto = idProdotto;
    }
}
