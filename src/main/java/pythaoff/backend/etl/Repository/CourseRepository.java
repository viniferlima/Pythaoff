package pythaoff.backend.etl.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pythaoff.backend.etl.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    public Course findByName(String nome);
}
