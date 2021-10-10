package pythaoff.backend.etl.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pythaoff.backend.etl.model.Grade;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    public Grade findByName(String nome);

}
