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
@Table(name = "dimPermission")
public class DimPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permission")
    private Long id_permission;

    @Column(name = "type_permission")
    private String type_permission;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dimPermission")
    private Set<FactAccessDate> factAccessDate;

    public Long getId_permission() {
        return id_permission;
    }

    public void setId_permission(Long id_permission) {
        this.id_permission = id_permission;
    }

    public String getType_permission() {
        return type_permission;
    }

    public void setType_permission(String type_permission) {
        this.type_permission = type_permission;
    }

    public Set<FactAccessDate> getFactAccessDate() {
        return factAccessDate;
    }

    public void setFactAccessDate(Set<FactAccessDate> factAccessDate) {
        this.factAccessDate = factAccessDate;
    }

}
