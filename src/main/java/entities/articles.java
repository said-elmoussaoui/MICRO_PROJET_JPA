package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class articles {
    private int codeArticle;
    private String titre;
    private Double prix;
    private Integer stock;
    private String categorie;
    private String photo;
    private String auteur;
    private Collection<lignecommandes> lignecommandesByCodeArticle;
    @Transient
    private String message;

    @Id
    @Column(name = "CodeArticle", nullable = false)
    public int getCodeArticle() {
        return codeArticle;
    }

    public void setCodeArticle(int codeArticle) {
        this.codeArticle = codeArticle;
    }

    @Column(name = "titre", nullable = true, length = 20)
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Basic
    @Column(name = "prix", nullable = true, precision = 0)
    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    @Column(name = "stock", nullable = true)
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    //@Column(name = "Categorie", nullable = true, length = 20)
    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Column(name = "photo", nullable = true, length = 20)
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Column(name = "auteur", nullable = false, length = 20)
    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        articles articles = (articles) o;

        if (codeArticle != articles.codeArticle) return false;
        if (titre != null ? !titre.equals(articles.titre) : articles.titre != null) return false;
        if (prix != null ? !prix.equals(articles.prix) : articles.prix != null) return false;
        if (stock != null ? !stock.equals(articles.stock) : articles.stock != null) return false;
        if (categorie != null ? !categorie.equals(articles.categorie) : articles.categorie != null) return false;
        if (photo != null ? !photo.equals(articles.photo) : articles.photo != null) return false;
        if (auteur != null ? !auteur.equals(articles.auteur) : articles.auteur != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codeArticle;
        result = 31 * result + (titre != null ? titre.hashCode() : 0);
        result = 31 * result + (prix != null ? prix.hashCode() : 0);
        result = 31 * result + (stock != null ? stock.hashCode() : 0);
        result = 31 * result + (categorie != null ? categorie.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        result = 31 * result + (auteur != null ? auteur.hashCode() : 0);
        return result;
    }

    /*@OneToMany(mappedBy = "articlesByCodeArticle")
    public Collection<lignecommandes> getLignecommandesByCodeArticle() {
        return lignecommandesByCodeArticle;
    }

    public void setLignecommandesByCodeArticle(Collection<lignecommandes> lignecommandesByCodeArticle) {
        this.lignecommandesByCodeArticle = lignecommandesByCodeArticle;
    }*/
    @Transient
    public String getMessage() {
        return message;
    }
    @Transient
    public void setMessage(String message) {
        this.message = message;
    }
}
