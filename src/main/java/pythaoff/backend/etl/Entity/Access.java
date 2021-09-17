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
@Table(name = "access")
public class Access {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_access")
    private Long access_id;

    @Column(name = "id_access")
    private Date access_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_person")
    private Person person;

    public Long getAccess_id() {
        return access_id;
    }

    public void setAccess_id(Long access_id) {
        this.access_id = access_id;
    }

    public Date getAccess_date() {
        return access_date;
    }

    public void setAccess_date(Date access_date) {
        this.access_date = access_date;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
