import entities.*;
import javax.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            lignecommandes lign = new lignecommandes();
            lign.setCodeArticle(90);
            lign.setNumCommande(9);
            lign.setQteCde(90);

            entityManager.persist(lign);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Didn't wooooooooork");
            System.out.println(e);
            transaction.rollback();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
