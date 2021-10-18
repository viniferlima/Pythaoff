package pythaoff.backend.etl.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pythaoff.backend.etl.Entity.DimCourseClass;

public interface DimCourseClassRepository extends JpaRepository<DimCourseClass, Long>{
    
}
