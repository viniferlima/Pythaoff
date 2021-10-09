package pythaoff.backend.etl.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pythaoff.backend.etl.Entity.DimGrade;

public interface DimGradeRepository extends JpaRepository<DimGrade, Long> {

}
