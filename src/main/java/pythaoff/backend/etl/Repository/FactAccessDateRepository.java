package pythaoff.backend.etl.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pythaoff.backend.etl.Entity.FactAccessDate;

public interface FactAccessDateRepository extends JpaRepository<FactAccessDate, Long> {

}
