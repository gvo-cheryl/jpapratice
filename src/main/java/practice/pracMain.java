package practice;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class pracMain {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HS");
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction ex = em.getTransaction();

        ex.begin();

        Image image01 = new Image("image01", "/01");
        Image image02 = new Image("image02", "/02");
        Image image03 = new Image("image03", "/03");
        Product product = new Product("T-shirt");
        image01.setProduct(product);
        image02.setProduct(product);
        image03.setProduct(product);
        em.persist(image01);
        em.persist(image02);
        em.persist(image03);
        em.persist(product);

        ex.commit();

        System.out.println("productId: " + image01.getProduct().getId());

        try {

        } catch (Exception e) {
            e.printStackTrace();
            ex.rollback();
        } finally {
            em.close();
        }
        entityManagerFactory.close();
    }
}
