package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class clients {
    private int id;
    private String email;
    private String nom;
    private String prenom;
    private String adresse;
    private Integer codePostal;
    private String ville;
    private String tel;
    private String motPasse;
    private Collection<commandes> commandesById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "Email", nullable = true, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "Nom", nullable = true, length = 20)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Column(name = "prenom", nullable = true, length = 20)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Column(name = "adresse", nullable = true, length = 20)
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Column(name = "CodePostal", nullable = true)
    public Integer getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(Integer codePostal) {
        this.codePostal = codePostal;
    }

    @Column(name = "ville", nullable = true, length = 100)
    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Column(name = "Tel", nullable = true, length = 100)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Column(name = "MotPasse", nullable = true, length = 100)
    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        clients clients = (clients) o;

        if (id != clients.id) return false;
        if (email != null ? !email.equals(clients.email) : clients.email != null) return false;
        if (nom != null ? !nom.equals(clients.nom) : clients.nom != null) return false;
        if (prenom != null ? !prenom.equals(clients.prenom) : clients.prenom != null) return false;
        if (adresse != null ? !adresse.equals(clients.adresse) : clients.adresse != null) return false;
        if (codePostal != null ? !codePostal.equals(clients.codePostal) : clients.codePostal != null) return false;
        if (ville != null ? !ville.equals(clients.ville) : clients.ville != null) return false;
        if (tel != null ? !tel.equals(clients.tel) : clients.tel != null) return false;
        if (motPasse != null ? !motPasse.equals(clients.motPasse) : clients.motPasse != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (adresse != null ? adresse.hashCode() : 0);
        result = 31 * result + (codePostal != null ? codePostal.hashCode() : 0);
        result = 31 * result + (ville != null ? ville.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (motPasse != null ? motPasse.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "clientsByCodeClient")
    public Collection<commandes> getCommandesById() {
        return commandesById;
    }

    public void setCommandesById(Collection<commandes> commandesById) {
        this.commandesById = commandesById;
    }
}
