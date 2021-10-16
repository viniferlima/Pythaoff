package pythaoff.backend.etl.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pythaoff.backend.etl.model.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

}
