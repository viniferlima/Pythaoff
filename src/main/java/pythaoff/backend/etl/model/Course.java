package pythaoff.backend.etl.model;

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

//Curso
@Entity
@Table(name = "course")
public class Course {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long id;

    @Column(name = "course_name")
    private String name;

    @Column(name = "course_description")
    private String description;

    @JsonIgnore//@JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "class")
    private Set<CourseClass> classes;

}
