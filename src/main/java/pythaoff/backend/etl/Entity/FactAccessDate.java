package pythaoff.backend.etl.Entity;

import java.util.Date;
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

    @Column(name = "time_access")
    private Date time_access;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_access")
    private DimAccess dimAccess;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_permission")
    private DimPermission dimPermission;

    @Column(name = "qty_access")
    private Integer qty_access;

    public Long getId_fact() {
        return id_fact;
    }

    public void setId_fact(Long id_fact) {
        this.id_fact = id_fact;
    }

    public Date getTime_access() {
        return time_access;
    }

    public void setTime_access(Date time_access) {
        this.time_access = time_access;
    }

    public DimAccess getDimAccess() {
        return dimAccess;
    }

    public void setDimAccess(DimAccess dimAccess) {
        this.dimAccess = dimAccess;
    }

    public DimPermission getDimPermission() {
        return dimPermission;
    }

    public void setDimPermission(DimPermission dimPermission) {
        this.dimPermission = dimPermission;
    }

    public Integer getQty_access() {
        return qty_access;
    }

    public void setQty_access(Integer qty_access) {
        this.qty_access = qty_access;
    }

}
