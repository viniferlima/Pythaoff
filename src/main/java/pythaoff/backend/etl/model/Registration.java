package pythaoff.backend.etl.model;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

//Matricula
@Entity
@Table(name = "registration")
public class Registration {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_id")
    private Long id;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    @JsonIgnoreProperties(value = "accesses", allowSetters = true)
    private Person person;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "class_id")
    @JsonIgnoreProperties(value = "registrations", allowSetters = true)
    private CourseClass courseClass;

    public Long getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public CourseClass getCourseClass() {
        return courseClass;
    }

    public void setCourseClass(CourseClass courseClass) {
        this.courseClass = courseClass;
    }

}
