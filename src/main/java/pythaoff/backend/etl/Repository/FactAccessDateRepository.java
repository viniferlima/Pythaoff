package pythaoff.backend.etl.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pythaoff.backend.etl.Entity.FactAccessDate;

public interface FactAccessDateRepository extends JpaRepository<FactAccessDate, Long> {

    public List<FactAccessDate> findAllByOrderByAccessDate();

}
