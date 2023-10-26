package fit.iuh.edu.vn.ongk.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ConnetionMap {
    public static void main(String[] args) {
        try {
            EntityManager entityManager = Persistence.createEntityManagerFactory("ongk").createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityTransaction.commit();
            System.out.println("ok");
        }catch (Exception exception){
            System.out.println("not ok");
        }
    }
}
