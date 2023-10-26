package fit.iuh.edu.vn.ongk.modules;

import com.fasterxml.jackson.annotation.JsonBackReference;
import fit.iuh.edu.vn.ongk.enums.Roles;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "experience")
@NamedQueries({
        @NamedQuery(name = "get-by-info-ex-canid",query = "select e from Experience e where e.candidate.id = :id")
})
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id")
    private long id;
    @Column(name = "from_date")
    private LocalDate fromDate;
    @Column(name = "work_des")
    private String workDescription;
    @Column(name = "company")
    private String companyName;
    @Column(name = "to_date")
    private LocalDate toDate;
    @Column(name = "role")
    private Roles role;

    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;
    public Experience() {
    }

    public Experience(LocalDate fromDate, String workDescription, String companyName, LocalDate toDate, Roles role, Candidate candidate) {
        this.fromDate = fromDate;
        this.workDescription = workDescription;
        this.companyName = companyName;
        this.toDate = toDate;
        this.role = role;
        this.candidate = candidate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", fromDate=" + fromDate +
                ", workDescription='" + workDescription + '\'' +
                ", companyName='" + companyName + '\'' +
                ", toDate=" + toDate +
                ", role=" + role +
                '}';
    }
}
