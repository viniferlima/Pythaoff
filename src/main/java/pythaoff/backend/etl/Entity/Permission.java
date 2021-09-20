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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_id")
    private Long id;

    @Column(name = "permission_type")
    private String type;

    @JsonIgnore//@JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "permission")
    private Set<Person> people;

    // @JsonProperty(value = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long permission_id) {
        this.id = permission_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String permission_type) {
        this.type = permission_type;
    }

    public Set<Person> getPeople() {
        return people;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }

}
