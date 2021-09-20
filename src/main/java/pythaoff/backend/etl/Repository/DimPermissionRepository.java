package pythaoff.backend.etl.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pythaoff.backend.etl.Entity.DimPermission;

public interface DimPermissionRepository extends JpaRepository<DimPermission, Long> {

}
