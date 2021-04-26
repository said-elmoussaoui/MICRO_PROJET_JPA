package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class commandes {
    private int numCommande;
    private Integer codeClient;
    private String dateCommande;
    private clients clientsByCodeClient;
    private Collection<lignecommandes> lignecommandesByNumCommande;

    @Id
    @Column(name = "NumCommande", nullable = false)
    public int getNumCommande() {
        return numCommande;
    }

    public void setNumCommande(int numCommande) {
        this.numCommande = numCommande;
    }

    //@Column(name = "CodeClient", nullable = true)
    public Integer getCodeClient() {
        return codeClient;
    }

    public void setCodeClient(Integer codeClient) {
        this.codeClient = codeClient;
    }

    @Column(name = "DateCommande", nullable = true, length = 20)
    public String getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(String dateCommande) {
        this.dateCommande = dateCommande;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        commandes commandes = (commandes) o;

        if (numCommande != commandes.numCommande) return false;
        if (codeClient != null ? !codeClient.equals(commandes.codeClient) : commandes.codeClient != null) return false;
        if (dateCommande != null ? !dateCommande.equals(commandes.dateCommande) : commandes.dateCommande != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numCommande;
        result = 31 * result + (codeClient != null ? codeClient.hashCode() : 0);
        result = 31 * result + (dateCommande != null ? dateCommande.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CodeClient", referencedColumnName = "id")
    public clients getClientsByCodeClient() {
        return clientsByCodeClient;
    }

    public void setClientsByCodeClient(clients clientsByCodeClient) {
        this.clientsByCodeClient = clientsByCodeClient;
    }

    @OneToMany(mappedBy = "commandesByNumCommande")
    public Collection<lignecommandes> getLignecommandesByNumCommande() {
        return lignecommandesByNumCommande;
    }

    public void setLignecommandesByNumCommande(Collection<lignecommandes> lignecommandesByNumCommande) {
        this.lignecommandesByNumCommande = lignecommandesByNumCommande;
    }
}
