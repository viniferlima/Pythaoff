package pythaoff.backend.etl.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pythaoff.backend.etl.Entity.DimRegistration;

public interface DimRegistrationRepository extends JpaRepository<DimRegistration, Long>{
    
}
