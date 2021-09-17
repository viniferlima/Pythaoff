package pythaoff.backend.etl.Entity;

import java.util.Date;
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
@Table(name = "dimAccess")
public class DimAccess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_access")
    private Long id_access;

    @Column(name = "time_access")
    private Date time_access;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dimAccess")
    private Set<FactAccessDate> factAccessDate;

    public Long getId_access() {
        return id_access;
    }

    public void setId_access(Long id_access) {
        this.id_access = id_access;
    }

    public Date getTime_access() {
        return time_access;
    }

    public void setTime_access(Date time_access) {
        this.time_access = time_access;
    }

    public Set<FactAccessDate> getFactAccessDate() {
        return factAccessDate;
    }

    public void setFactAccessDate(Set<FactAccessDate> factAccessDate) {
        this.factAccessDate = factAccessDate;
    }

}
