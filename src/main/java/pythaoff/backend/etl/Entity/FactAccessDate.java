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

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @Column(name = "permissionType")
    private String permissionType;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "dimAccess_id")
    private DimAccess dimAccess;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "dimPerson_id")
    private DimPerson dimPerson;

    @JsonIgnore
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

    public String getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(String permissionType) {
        this.permissionType = permissionType;
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

    public FactAccessDate(String personName, String personEmail, Date accessDate, String permissionType,
            DimAccess dimAccess, DimPerson dimPerson, DimPermission dimPermission) {
        this.personName = personName;
        this.personEmail = personEmail;
        this.accessDate = accessDate;
        this.permissionType = permissionType;
        this.dimAccess = dimAccess;
        this.dimPerson = dimPerson;
        this.dimPermission = dimPermission;
    }

    public FactAccessDate() {}

    
    
}
