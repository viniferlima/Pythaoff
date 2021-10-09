package pythaoff.backend.etl.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pythaoff.backend.etl.model.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
    public Permission findFirstByType(String type);
}
