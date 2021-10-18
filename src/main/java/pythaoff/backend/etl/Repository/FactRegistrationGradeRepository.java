package pythaoff.backend.etl.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pythaoff.backend.etl.Entity.FactRegistrationGrade;

public interface FactRegistrationGradeRepository extends JpaRepository<FactRegistrationGrade, Long>{
    public List<FactRegistrationGrade> findAllByCourseName(String courseName);
    public List<FactRegistrationGrade> findAll();
}
