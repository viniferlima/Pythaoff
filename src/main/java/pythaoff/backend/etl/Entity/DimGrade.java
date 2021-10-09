package pythaoff.backend.etl.Entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class DimGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grade")
    private Long id_access;

    @Column(name = "person")
    private Person person;

    @Column(name = "course")
    private String course;

    @Column(name = "average_grade")
    private String average_grade;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dimGrade")
    private Set<FactAccessDate> factAccessDate;

    public Set<FactAccessDate> getFactAccessDate() {
        return factAccessDate;
    }

    public void setFactAccessDate(Set<FactAccessDate> factAccessDate) {
        this.factAccessDate = factAccessDate;
    }

    public Long getId_access() {
        return id_access;
    }

    public void setId_access(Long id_access) {
        this.id_access = id_access;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getAverage_grade() {
        return average_grade;
    }

    public void setAverage_grade(String average_grade) {
        this.average_grade = average_grade;
    }

}
