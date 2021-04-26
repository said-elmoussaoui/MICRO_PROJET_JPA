package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class lignecommandes implements Serializable {
    private int numCommande;
    private int codeArticle;
    private Integer qteCde;
    private commandes commandesByNumCommande;
    private articles articlesByCodeArticle;

    @Id
    @Column(name = "NumCommande", nullable = false)
    public int getNumCommande() {
        return numCommande;
    }

    public void setNumCommande(int numCommande) {
        this.numCommande = numCommande;
    }

    @Id
    @Column(name = "CodeArticle", nullable = false)
    public int getCodeArticle() {
        return codeArticle;
    }

    public void setCodeArticle(int codeArticle) {
        this.codeArticle = codeArticle;
    }

    @Column(name = "QteCde", nullable = true)
    public Integer getQteCde() {
        return qteCde;
    }

    public void setQteCde(Integer qteCde) {
        this.qteCde = qteCde;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        lignecommandes that = (lignecommandes) o;

        if (numCommande != that.numCommande) return false;
        if (codeArticle != that.codeArticle) return false;
        if (qteCde != null ? !qteCde.equals(that.qteCde) : that.qteCde != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numCommande;
        result = 31 * result + codeArticle;
        result = 31 * result + (qteCde != null ? qteCde.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "NumCommande", referencedColumnName = "NumCommande", nullable = false)
    public commandes getCommandesByNumCommande() {
        return commandesByNumCommande;
    }

    public void setCommandesByNumCommande(commandes commandesByNumCommande) {
        this.commandesByNumCommande = commandesByNumCommande;
    }

    @ManyToOne
    @JoinColumn(name = "CodeArticle", referencedColumnName = "CodeArticle", nullable = false)
    public articles getArticlesByCodeArticle() {
        return articlesByCodeArticle;
    }

    public void setArticlesByCodeArticle(articles articlesByCodeArticle) {
        this.articlesByCodeArticle = articlesByCodeArticle;
    }
}
