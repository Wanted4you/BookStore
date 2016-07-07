package big.proj.ee.JPA;

import javax.persistence.*;

/**
 * Created by Влад on 30.06.2016.
 */
public class Main {

    public static void main(String[] args) {
        Book book = new Book("H2G2", "Игры в которые играют люди", 17.5F, "1-84023-742-2", 354, false);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.persist(book);
            tx.commit();
        }catch (PersistenceException p_e){
            p_e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
