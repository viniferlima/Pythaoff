package pythaoff.backend.etl;

import java.util.Date;

import pythaoff.backend.etl.Entity.Access;
import pythaoff.backend.etl.Entity.DimAccess;
import pythaoff.backend.etl.Entity.DimPermission;
import pythaoff.backend.etl.Entity.FactAccessDate;
import pythaoff.backend.etl.Entity.Permission;
import pythaoff.backend.etl.Entity.Person;

public interface PythaoffServices {

    public Person NewPerson(String name, Permission perm);

    public Access NewAccess(Date date, Person person);

    public Permission NewPermission(String type_permission);

    public DimAccess NewDimAccess(Date time_access);

    public DimPermission NewDimPermission(String type_permission);

    public FactAccessDate NewFactAccessDate(Date time_access, DimAccess dimAccess, DimPermission dimPermission,
            Integer qty_access);

}
