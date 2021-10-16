package pythaoff.backend.etl.Entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "dimPerson")
public class DimPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dimPerson_id")
    private Long id_access;

    @Column(name = "dimPerson_name")
    private String name;

    @Column(name = "dimPerson_email")
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dimPerson")
    private Set<FactAccessDate> factAccessDate;

    public Long getId_access() {
        return id_access;
    }

    public void setId_access(Long id_access) {
        this.id_access = id_access;
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

}
