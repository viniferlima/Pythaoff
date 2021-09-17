package pythaoff.backend.etl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import pythaoff.backend.etl.Entity.Access;
import pythaoff.backend.etl.Entity.DimAccess;
import pythaoff.backend.etl.Entity.DimPermission;
import pythaoff.backend.etl.Entity.FactAccessDate;
import pythaoff.backend.etl.Entity.Permission;
import pythaoff.backend.etl.Entity.Person;
import pythaoff.backend.etl.Repository.AccessRepository;
import pythaoff.backend.etl.Repository.DimAccessRepository;
import pythaoff.backend.etl.Repository.DimPermissionRepository;
import pythaoff.backend.etl.Repository.FactAccessDateRepository;
import pythaoff.backend.etl.Repository.PermissionRepository;
import pythaoff.backend.etl.Repository.PersonRepository;

@SpringBootTest
@Transactional
@Rollback
class EtlApplicationTests {

	@Autowired
	private PersonRepository personRepo;

	@Autowired
	private AccessRepository accessRepo;

	@Autowired
	private PermissionRepository permissionRepo;

	@Autowired
	private DimAccessRepository dimAccessRepo;

	@Autowired
	private FactAccessDateRepository FactAccessDateRepo;

	@Autowired
	private DimPermissionRepository dimPermissionRepo;

	@Test
	void contextLoads() {
	}

	// @Test
	// void InsertPersonTest() {
	// Person person = new Person();
	// person.setPsn_name("Gustavo");
	// personRepo.save(person);

	// assertNotNull(personRepo.findById(person.getPsn_id()));
	// }

	// @Test
	// void InsertAccessTest() {
	// Access access = new Access();
	// Date date = new Date();
	// access.setAccess_date(date);
	// accessRepo.save(access);

	// assertNotNull(personRepo.findById(access.getAccess_id()));
	// }

	// @Test
	// void InsertPermissionTest() {
	// Permission permission = new Permission();
	// permission.setPermission_type("Teste");
	// ;
	// permissionRepo.save(permission);

	// assertNotNull(personRepo.findById(permission.getPermission_id()));
	// }

	// @Test
	// void InsertDimPermissionTest() {
	// DimPermission dimPerm = new DimPermission();
	// dimPerm.setType_permission("Teste");
	// dimPermissionRepo.save(dimPerm);

	// assertNotNull(dimPermissionRepo.findById(dimPerm.getId_permission()));
	// }

	// @Test
	// void InsertFactAccessDateTest() {
	// DimAccess dimAcces = new DimAccess();
	// Date date = new Date();
	// dimAcces.setTime_access(date);
	// dimAccessRepo.save(dimAcces);

	// assertNotNull(dimAccessRepo.findById(dimAcces.getId_access()));
	// }

	// @Test
	// void InsertDimAccessTest() {
	// FactAccessDate factAccess = new FactAccessDate();
	// factAccess.setQty_access(10);
	// FactAccessDateRepo.save(factAccess);

	// assertNotNull(FactAccessDateRepo.findById(factAccess.getId_fact()));
	// }
}
