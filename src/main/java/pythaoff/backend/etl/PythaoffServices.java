package pythaoff.backend.etl;

import java.util.Date;

import pythaoff.backend.etl.Entity.DimAccess;
import pythaoff.backend.etl.Entity.DimPermission;
import pythaoff.backend.etl.Entity.DimPerson;
import pythaoff.backend.etl.Entity.DimGrade;
import pythaoff.backend.etl.Entity.FactAccessDate;
import pythaoff.backend.etl.model.Access;
import pythaoff.backend.etl.model.Course;
import pythaoff.backend.etl.model.CourseClass;
import pythaoff.backend.etl.model.Grade;
import pythaoff.backend.etl.model.Permission;
import pythaoff.backend.etl.model.Person;
import pythaoff.backend.etl.model.Registration;

public interface PythaoffServices {

    public Person NewPerson(String name, String email, String perm);

    public Access NewAccess(Date date, Person person, String name);

    public Permission NewPermission(String type_permission);

    public Grade NewGrade(String name, Registration registration, DimGrade dimGrade);

    public Course NewCourse(String name, String descricao);

    public Registration NewRegistration(Person person, CourseClass courseClass);

    public CourseClass NewCourseClass(String name, Date startdate, Date endDate, Course course);

    public DimGrade NewDimGrade(Person person, Course course, String average_grade);

    public DimPerson NewDimPerson(String name, String email);

    public DimAccess NewDimAccess(Person person);

    public DimPermission NewDimPermission(String type_permission);

    public FactAccessDate NewFactAccessDate(Date time_access, DimAccess dimAccess, DimPermission dimPermission,
            Integer qty_access);

}
