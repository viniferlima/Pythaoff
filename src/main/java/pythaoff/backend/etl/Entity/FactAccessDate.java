package pythaoff.backend.etl.Entity;

import java.util.Date;

import javax.persistence.CascadeType;
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

    @Column(name = "personName")
    private String personName;

    @Column(name = "personEmail")
    private String personEmail;

    @Column(name = "accessDate")
    private Date accessDate;

    @Column(name = "gradeValue")
    private Long gradeValue;

    @Column(name = "permissionType")
    private String permissionType;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "dimGrade_id")
    private DimGrade dimGrade;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "dimAccess_id")
    private DimAccess dimAccess;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "dimPerson_id")
    private DimPerson dimPerson;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "dimPermission_id")
    private DimPermission dimPermission;

    public Long getId_fact() {
        return id_fact;
    }

    public void setId_fact(Long id_fact) {
        this.id_fact = id_fact;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }

    public Date getAccessDate() {
        return accessDate;
    }

    public void setAccessDate(Date accessDate) {
        this.accessDate = accessDate;
    }

    public Long getGradeValue() {
        return gradeValue;
    }

    public void setGradeValue(Long gradeValue) {
        this.gradeValue = gradeValue;
    }

    public String getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(String permissionType) {
        this.permissionType = permissionType;
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

    public DimPermission getDimPermission() {
        return dimPermission;
    }

    public void setDimPermission(DimPermission dimPermission) {
        this.dimPermission = dimPermission;
    }


    
}
