package pythaoff.backend.etl;

import java.util.Date;

import pythaoff.backend.etl.Entity.DimAccess;
import pythaoff.backend.etl.Entity.DimCourse;
import pythaoff.backend.etl.Entity.DimCourseClass;
import pythaoff.backend.etl.Entity.DimGrade;
import pythaoff.backend.etl.Entity.DimPermission;
import pythaoff.backend.etl.Entity.DimPerson;
import pythaoff.backend.etl.Entity.DimRegistration;
import pythaoff.backend.etl.Entity.FactAccessDate;
import pythaoff.backend.etl.Entity.FactRegistrationGrade;
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

    public Grade NewGrade(Long id, Registration registration);

    public Course NewCourse(String name, String descricao);

    public Registration NewRegistration(Person person, CourseClass courseClass);

    public CourseClass NewCourseClass(String name, Date startdate, Date endDate, Course course);

    public DimGrade NewDimGrade(Long grade);

    public DimPerson NewDimPerson(String name, String email);

    public DimAccess NewDimAccess(String date);

    public DimPermission NewDimPermission(String type_permission);

    public FactAccessDate NewFactAccessDate(Date time_access, DimAccess dimAccess, DimPermission dimPermission,
            Integer qty_access);

    public DimCourse NewDimCourse(String name, String description);

    public DimCourseClass NewDimCourseClass(String name, Date startDate, Date endDate);

    public DimRegistration NewDimRegistration(Long id);

    public FactRegistrationGrade NewFactRegistrationGrade(Long id_fact, String dimCourseClassName, Date courseClassStartDate,
    Date courseClassEndDate, Long registrationId, String courseName, String courseDescription,
    String personName, String personEmail, Long grade, String permissionType, DimCourseClass dimCourseClass,
    DimRegistration dimRegistration, DimCourse dimCourse, DimPerson dimPerson, DimGrade dimGrade,
    DimPermission dimPermission);

}
