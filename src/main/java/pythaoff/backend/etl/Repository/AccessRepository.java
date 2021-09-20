package pythaoff.backend.etl.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pythaoff.backend.etl.Entity.Access;

public interface AccessRepository extends JpaRepository<Access, Long> {

}
