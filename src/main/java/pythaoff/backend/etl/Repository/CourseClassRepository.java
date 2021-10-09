package pythaoff.backend.etl.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pythaoff.backend.etl.model.CourseClass;

public interface CourseClassRepository extends JpaRepository<CourseClass, Long> {
    public CourseClass findByName(String nome);
}
