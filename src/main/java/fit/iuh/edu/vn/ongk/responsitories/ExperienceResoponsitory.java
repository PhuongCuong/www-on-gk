package fit.iuh.edu.vn.ongk.responsitories;

import fit.iuh.edu.vn.ongk.modules.Candidate;
import fit.iuh.edu.vn.ongk.modules.Experience;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ExperienceResoponsitory {

    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public ExperienceResoponsitory() {
        entityManager = Persistence.createEntityManagerFactory("ongk")
                .createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    public boolean insertCan(Experience experience){
        try{
            entityTransaction.begin();
            entityManager.persist(experience);
            entityTransaction.commit();
            return true;
        }catch (Exception ex){
            entityTransaction.rollback();
            System.out.println("ex:"+ex);
        }
        return false;
    }

    public boolean updateCan(Experience experience){
        try{
            entityTransaction.begin();
            entityManager.merge(experience);
            entityTransaction.commit();
            return true;
        }catch (Exception ex){
            entityTransaction.rollback();
            System.out.println("ex:"+ex);
        }
        return false;
    }

    public List<Experience> getAllexbycanid(long id){
        TypedQuery<Experience> query = entityManager.createNamedQuery("get-by-info-ex-canid", Experience.class);
        query.setParameter("id",id);
        return query.getResultList();
    }
}
