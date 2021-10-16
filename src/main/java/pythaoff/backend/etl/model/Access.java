package pythaoff.backend.etl.model;

import java.time.ZonedDateTime;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "access")
public class Access {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "access_id")
    private Long id;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @Column(name = "access_date")
    private Date accessDate;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    @JsonIgnoreProperties(value = "accesses", allowSetters = true)
    private Person person;

    // @JsonProperty(value = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long access_id) {
        this.id = access_id;
    }

    public Date getDate() {
        return accessDate;
    }

    public void setDateFromString(String dateString) {
        this.accessDate = Date.from(ZonedDateTime.parse(dateString).toInstant());
    }

    public void setDate(Date access_date) {
        this.accessDate = access_date;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
