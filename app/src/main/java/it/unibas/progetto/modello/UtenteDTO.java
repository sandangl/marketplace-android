package it.unibas.progetto.modello;

public class UtenteDTO {

    private String email;
    private String password;

    public UtenteDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UtenteDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
