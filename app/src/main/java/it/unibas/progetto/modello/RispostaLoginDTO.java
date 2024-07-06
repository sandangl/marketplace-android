package it.unibas.progetto.modello;

public class RispostaLoginDTO {

    private String nome;
    private String cognome;
    private String email;
    private String authToken;

    public RispostaLoginDTO() {
    }

    public RispostaLoginDTO(String nome, String cognome, String email, String authToken) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.authToken = authToken;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
