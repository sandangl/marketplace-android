package it.unibas.progetto.modello;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrdineDTO {
    private Long id;
    private LocalDate data;
    private double totale;
    private Long idUtente;
    private List<AcquistoDTO> acquisti = new ArrayList<>();

    public OrdineDTO() {
    }

    public OrdineDTO(Long id, LocalDate data, double totale, Long idUtente) {
        this.id = id;
        this.data = data;
        this.totale = totale;
        this.idUtente = idUtente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getTotale() {
        return totale;
    }

    public void setTotale(double totale) {
        this.totale = totale;
    }

    public Long getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Long idUtente) {
        this.idUtente = idUtente;
    }

    public List<AcquistoDTO> getAcquisti() {
        return acquisti;
    }

    public void setAcquisti(List<AcquistoDTO> acquisti) {
        this.acquisti = acquisti;
    }
}
