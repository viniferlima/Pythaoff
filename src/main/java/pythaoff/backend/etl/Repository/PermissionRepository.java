package pythaoff.backend.etl.Repository;

import pythaoff.backend.etl.Entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
    public Permission findFirstByType(String type);
}
