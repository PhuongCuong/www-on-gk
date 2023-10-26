package fit.iuh.edu.vn.ongk.responsitories;

import fit.iuh.edu.vn.ongk.enums.Roles;
import fit.iuh.edu.vn.ongk.modules.Candidate;
import fit.iuh.edu.vn.ongk.modules.Experience;
import jakarta.persistence.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CandidateResponsitory {
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;
    private TypedQuery<Object[]> query;

    public CandidateResponsitory() {
        entityManager = Persistence.createEntityManagerFactory("ongk")
                .createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    public boolean insertCan(Candidate candidate){
        try{
            entityTransaction.begin();
            entityManager.persist(candidate);
            entityTransaction.commit();
            return true;
        }catch (Exception ex){
            entityTransaction.rollback();
            System.out.println("ex:"+ex);
        }
        return false;
    }

    public boolean updateCan(Candidate candidate){
        try{
            entityTransaction.begin();
            entityManager.merge(candidate);
            entityTransaction.commit();
            return true;
        }catch (Exception ex){
            entityTransaction.rollback();
            System.out.println("ex:"+ex);
        }
        return false;
    }

    public List<Candidate> getAllcan(){
        return entityManager.createNamedQuery("get-all-candidate",Candidate.class).getResultList();
    }

    public Optional<Candidate> getcanbyid(long id) {
        Candidate candidate = entityManager.createNamedQuery("get-info-can-by-id",Candidate.class)
                .setParameter("id",id).getSingleResult();
        return candidate == null ? Optional.empty() : Optional.of(candidate);
    }

    public List<Candidate> getcanbyrole(Roles roles){
        return entityManager.createNamedQuery("get-candidate-by-role",Candidate.class)
                .setParameter("role",roles).getResultList();
    }

    public List<Candidate> getcanbyemail(){
        return entityManager.createNamedQuery("get-can-by-email",Candidate.class).getResultList();
    }

}
