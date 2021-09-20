package pythaoff.backend.etl.Entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")
    private Long psn_id;

    @Column(name = "name")
    private String psn_name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
    private Set<Access> accesses;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_permission")
    private Permission permission;

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public Set<Access> getAccesses() {
        return accesses;
    }

    public void setAccesses(Set<Access> accesses) {
        this.accesses = accesses;
    }

    public Long getPsn_id() {
        return psn_id;
    }

    public void setPsn_id(Long psn_id) {
        this.psn_id = psn_id;
    }

    public String getPsn_name() {
        return psn_name;
    }

    public void setPsn_name(String psn_name) {
        this.psn_name = psn_name;
    }

}
