package fit.iuh.edu.vn.ongk.modules;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "candidate")
@NamedQueries({
        @NamedQuery(name = "get-all-candidate",query = "select c from Candidate c"),
        @NamedQuery(name = "get-info-can-by-id",query = "select c from Candidate c " +
                "inner join Experience ex on c.id = ex.candidate.id where c.id = :id"),
        @NamedQuery(name = "get-candidate-by-role",query = "select c from Candidate c " +
                "inner join Experience ex on c.id = ex.candidate.id where ex.role = :role"),
        @NamedQuery(name = "get-can-by-email",query = "select c from Candidate c where c.email like '%@gmail.com'")
})
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "can_id")
    private long id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "candidate")
    @JsonManagedReference
    private List<Experience> experiences;

    public Candidate() {
    }

    public Candidate(String fullName, String email, String phone) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
