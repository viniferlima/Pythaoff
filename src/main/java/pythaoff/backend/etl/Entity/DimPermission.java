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

import pythaoff.backend.etl.model.Person;

@Entity
@Table(name = "dimPermission")
public class DimPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dimPermission_id")
    private Long id;

    @Column(name = "dimPermission_typePermission")
    private String type;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dimPermission")
    private Set<FactAccessDate> factAccessDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id_permission) {
        this.id = id_permission;
    }

    public String getType() {
        return type;
    }

    public void setType_permission(String type_permission) {
        this.type = type_permission;
    }

    public Set<FactAccessDate> getFactAccessDate() {
        return factAccessDate;
    }

    public void setFactAccessDate(Set<FactAccessDate> factAccessDate) {
        this.factAccessDate = factAccessDate;
    }

}
