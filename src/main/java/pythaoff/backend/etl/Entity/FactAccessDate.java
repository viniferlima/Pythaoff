package pythaoff.backend.etl.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "factAccessDate")
public class FactAccessDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fact")
    private Long id_fact;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "grade")
    private String grade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iddimGrade")
    private DimGrade dimGrade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iddimAccess")
    private DimAccess dimAccess;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iddimPerson")
    private DimPerson dimPerson;

    @Column(name = "qty_access")
    private Integer qty_access;

    public Long getId_fact() {
        return id_fact;
    }

    public void setId_fact(Long id_fact) {
        this.id_fact = id_fact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public DimGrade getDimGrade() {
        return dimGrade;
    }

    public void setDimGrade(DimGrade dimGrade) {
        this.dimGrade = dimGrade;
    }

    public DimAccess getDimAccess() {
        return dimAccess;
    }

    public void setDimAccess(DimAccess dimAccess) {
        this.dimAccess = dimAccess;
    }

    public DimPerson getDimPerson() {
        return dimPerson;
    }

    public void setDimPerson(DimPerson dimPerson) {
        this.dimPerson = dimPerson;
    }

    public Integer getQty_access() {
        return qty_access;
    }

    public void setQty_access(Integer qty_access) {
        this.qty_access = qty_access;
    }

}
