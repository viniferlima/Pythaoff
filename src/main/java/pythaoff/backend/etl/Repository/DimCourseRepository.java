package pythaoff.backend.etl.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pythaoff.backend.etl.Entity.DimCourse;

public interface DimCourseRepository extends JpaRepository<DimCourse, Long> {
    
}
