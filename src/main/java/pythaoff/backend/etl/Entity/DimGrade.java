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
@Table(name = "dimGrade")
public class DimGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dimGrade_id")
    private Long id;

    @Column(name = "dimGrade_grade")
    private Double grade;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dimGrade")
    private Set<FactRegistrationGrade> factRegistrationGrade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    

}
