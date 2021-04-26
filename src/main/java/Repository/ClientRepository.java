package Repository;

import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Date;

public class ClientRepository {
	 private EntityManager entityManager;
	  private EntityManagerFactory emf;

	  public ClientRepository() {
	    this.emf = Persistence.createEntityManagerFactory("default");
	    this.entityManager = this.emf.createEntityManager();
	  }

	  public ClientRepository(String pu) {
	    this.emf = Persistence.createEntityManagerFactory(pu);
	    this.entityManager = this.emf.createEntityManager();
	  }
	public boolean inscrire(clients client) {
		boolean br = false;
		entityManager.getTransaction().begin();
	    entityManager.persist(client);
	    br = true;
	    entityManager.getTransaction().commit();
	    return br;
	}
	public boolean TestConnexion(String email,String password) {
		Query query = entityManager.createQuery("Select c from clients c where c.email = '"+email+"' and c.motPasse = '"+password+"'");
	    if(query.getResultList() != null) return true;
	    else return false;
	}
	public clients GetByEmail(String email) {
		 Query query = entityManager.createQuery("Select c from clients c where c.email= '"+email+"'");
		 return (clients) query.getSingleResult();
	}
	public clients GetById(int Id) {
		Query query = entityManager.createQuery("Select c from clients c where c.id = '"+Id+"'");
		return (clients) query.getSingleResult();
	}
	public commandes getComByIdClient(int idC) {
		Query query = entityManager.createQuery("select c from commandes c where c.codeClient = '"+idC+"'");
		return (commandes) query.getSingleResult();
	}
	public void reduceArticle(int nbr,int idArt) {
		ArticleRepository article = new ArticleRepository();
		int nbrArt = article.showArticleById(idArt).getStock();
		entityManager.getTransaction().begin();
	    Query query = entityManager.createQuery("Update articles a set a.stock = '"+(nbrArt-nbr)+"' where a.codeArticle = " + idArt );
	    query.executeUpdate();
	    entityManager.getTransaction().commit();
	    entityManager.clear();
	}
	public void DemandeArticleAdjoint(lignecommandes lc) {
		entityManager.getTransaction().begin();
	    entityManager.persist(lc);
	    entityManager.getTransaction().commit();
	}
	public boolean DemanderArticle(int idClient,int idArticle,int qte) {
		boolean resultat = false;
		Date date = new Date();
		String year = ""+date.getYear();
		String heur = ""+date.getHours();
		String min = ""+date.getMinutes();
		if(date.getMinutes()<10) min = "0"+date.getMinutes();
		if(date.getHours()<10)   heur = "0"+date.getHours();
		String dateDemande = date.getDate()+"/"+date.getMonth()+"/20"+year.substring(1,3)+"  "+heur+"::"+min;
		int NumCommande = getComByIdClient(idClient).getNumCommande();
		commandes commande = new commandes();
		commande.setCodeClient(idClient);
		commande.setDateCommande(dateDemande);
		commande.setNumCommande(NumCommande);
		entityManager.getTransaction().begin();
	    entityManager.persist(commande);
	    entityManager.getTransaction().commit();
		lignecommandes lc = new lignecommandes();
		lc.setNumCommande(NumCommande);
		lc.setCodeArticle(idArticle);
		lc.setQteCde(qte);
		DemandeArticleAdjoint(lc);
		reduceArticle(qte,idArticle); 
		resultat = true;
		return resultat;
	}

}
