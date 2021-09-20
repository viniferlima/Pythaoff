package pythaoff.backend.etl.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pythaoff.backend.etl.Entity.DimAccess;

public interface DimAccessRepository extends JpaRepository<DimAccess, Long> {

}
