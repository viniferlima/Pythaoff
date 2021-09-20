package pythaoff.backend.etl;

import java.util.Date;
import java.util.HashSet;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service("PythaoffServices")
public class PythaoffServicesImpl implements PythaoffServices {

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

    @Override
    @Transactional
    public Person NewPerson(String name, Permission perm) {

        Person person = new Person();
        person.setNome(name);
        person.setPermission(perm);
        person.setAccesses(new HashSet<Access>());
        personRepo.save(person);

        return person;
    }

    @Override
    @Transactional
    public Access NewAccess(Date date, Person person) {

        Access access = new Access();
        access.setDate(date);
        access.setPerson(person);
        accessRepo.save(access);

        return access;
    }

    @Override
    @Transactional
    public Permission NewPermission(String type_permission) {

        Permission permission = new Permission();
        permission.setType(type_permission);
        permissionRepo.save(permission);

        return permission;
    }

    @Override
    @Transactional
    public DimAccess NewDimAccess(Date time_access) {

        DimAccess dimAccess = new DimAccess();
        dimAccess.setTime_access(time_access);
        dimAccessRepo.save(dimAccess);

        return dimAccess;
    }

    @Override
    @Transactional
    public DimPermission NewDimPermission(String type_permission) {

        DimPermission dimPermission = new DimPermission();
        dimPermission.setType_permission(type_permission);
        dimPermissionRepo.save(dimPermission);

        return dimPermission;
    }

    @Override
    @Transactional
    public FactAccessDate NewFactAccessDate(Date time_access, DimAccess dimAccess, DimPermission dimPermission,
            Integer qty_access) {

        FactAccessDate factAccessDate = new FactAccessDate();
        factAccessDate.setTime_access(time_access);
        factAccessDate.setDimAccess(dimAccess);
        factAccessDate.setDimPermission(dimPermission);
        factAccessDate.setQty_access(qty_access);
        FactAccessDateRepo.save(factAccessDate);

        return factAccessDate;
    }

}
