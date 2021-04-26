package Repository;


import entities.articles;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ArticleRepository {
	  private EntityManager entityManager;
	  private EntityManagerFactory emf;

	  public ArticleRepository() {
	    this.emf = Persistence.createEntityManagerFactory("default");
	    this.entityManager = this.emf.createEntityManager();
	  }

	  public ArticleRepository(String pu) {
	    this.emf = Persistence.createEntityManagerFactory(pu);
	    this.entityManager = this.emf.createEntityManager();
	  }
	public List<articles> showArticle(String genre){
		System.out.println(genre);
		Query query = entityManager.createQuery("Select a from articles a where a.categorie = '"+genre+"'");
		System.out.println("size = "+query.getResultList().size());
	    return query.getResultList();
		//return entityManager.createQuery("Select a from articles a where a.categorie LIKE :genre").setParameter("genre",genre).getResultList();
	}
	public List<articles> showAllArticle(){
		Query query = entityManager.createQuery("Select a from articles a");
	    return query.getResultList();
		}
	public articles showArticleById(int id) {
		return entityManager.find(articles.class, id);
	}
	public List<String> showAllCat() {
			Query query = entityManager.createQuery("Select DISTINCT a.categorie from articles a");
			return query.getResultList();
}
}
