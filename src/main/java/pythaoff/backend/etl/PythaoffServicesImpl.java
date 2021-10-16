package pythaoff.backend.etl;

import java.util.Date;
import java.util.HashSet;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pythaoff.backend.etl.Entity.DimAccess;
import pythaoff.backend.etl.Entity.DimGrade;
import pythaoff.backend.etl.Entity.DimPermission;
import pythaoff.backend.etl.Entity.DimPerson;
import pythaoff.backend.etl.Entity.FactAccessDate;
import pythaoff.backend.etl.Repository.AccessRepository;
import pythaoff.backend.etl.Repository.CourseClassRepository;
import pythaoff.backend.etl.Repository.CourseRepository;
import pythaoff.backend.etl.Repository.DimAccessRepository;
import pythaoff.backend.etl.Repository.DimGradeRepository;
import pythaoff.backend.etl.Repository.DimPermissionRepository;
import pythaoff.backend.etl.Repository.DimPersonRepository;
import pythaoff.backend.etl.Repository.FactAccessDateRepository;
import pythaoff.backend.etl.Repository.GradeRepository;
import pythaoff.backend.etl.Repository.PermissionRepository;
import pythaoff.backend.etl.Repository.PersonRepository;
import pythaoff.backend.etl.Repository.RegistrationRepository;
import pythaoff.backend.etl.model.Access;
import pythaoff.backend.etl.model.Course;
import pythaoff.backend.etl.model.CourseClass;
import pythaoff.backend.etl.model.Grade;
import pythaoff.backend.etl.model.Permission;
import pythaoff.backend.etl.model.Person;
import pythaoff.backend.etl.model.Registration;

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

    @Autowired
    private DimPersonRepository dimPersonRepository;

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired 
    private CourseRepository courseRepository;

    @Autowired
    private CourseClassRepository courseClassRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private DimGradeRepository dimGradeRepository;

    @Override
    @Transactional
    public Person NewPerson(String name, String email, String perm) {
        Person usuario = personRepo.findByName(name);
        if (usuario == null) {
            usuario = new Person();
            usuario.setName(name);
            usuario.setEmail(email);
            usuario.setPermission(NewPermission(perm));
            usuario.setAccesses(new HashSet<Access>());
            personRepo.save(usuario);
        }

        NewDimPerson(name, email);

        return usuario;
    }

    @Override
    @Transactional
    public Access NewAccess(Date date, Person person, String name) {

        Access access = new Access();
        access.setDate(date);
        access.setPerson(person);
        accessRepo.save(access);

        return access;
    }

    @Override
    @Transactional
    public Permission NewPermission(String type_permission) {
        Permission permissao = permissionRepo.findFirstByType(type_permission);
        if (permissao == null) {
            permissao = new Permission();
            permissao.setType(type_permission);
            permissionRepo.save(permissao);
        }

        return permissao;
    }

    @Override
    @Transactional
    public Grade NewGrade(Long id, Registration registration, DimGrade dimGrade) {
        Grade grade = gradeRepository.findByRegistrationId(id);
        if (grade == null) {
            grade = new Grade();
            grade.setRegistration(NewRegistration(registration.getPerson(), registration.getCourseClass()));
            gradeRepository.save(grade);

        }
        NewDimGrade(dimGrade.getGrade());
        return grade;
    }

    @Override
    @Transactional
    public Registration NewRegistration(Person person, CourseClass courseClass) {

        Registration registration = new Registration();
        registration.setPerson(NewPerson(person.getName(), person.getEmail(), person.getPermission().getType()));

        registration.setCourseClass(NewCourseClass(courseClass.getName(), courseClass.getStartDate(),
                courseClass.getEndDate(), courseClass.getCourse()));

        registrationRepository.save(registration);

        return registration;

    }

    @Override
    @Transactional
    public CourseClass NewCourseClass(String name, Date startdate, Date endDate, Course course) {
        CourseClass courseClass = courseClassRepository.findByName(name);
        if (courseClass == null) {
            courseClass = new CourseClass();
            courseClass.setName(name);
            courseClass.setStartDate(startdate);
            courseClass.setEndDate(endDate);
            courseClass.setCourse(NewCourse(course.getName(), course.getDescription()));

            courseClassRepository.save(courseClass);
        }

        return courseClass;
    }

    @Override
    @Transactional
    public Course NewCourse(String name, String descricao) {
        Course course = courseRepository.findByName(name);
        if (course == null) {
            course = new Course();
            course.setName(name);
            course.setDescription(descricao);
            course.setClasses(new HashSet<CourseClass>());
            courseRepository.save(course);
        }

        return course;
    }

    @Override
    @Transactional
    public DimGrade NewDimGrade(Long grade) {

        DimGrade dimGrade = new DimGrade();
        dimGrade.setGrade(grade);
        dimGradeRepository.save(dimGrade);

        return dimGrade;
    }

    @Override
    @Transactional
    public DimPerson NewDimPerson(String name, String email) {
        DimPerson usuario = dimPersonRepository.findFirstByName(name);
        if (usuario == null) {
            usuario = new DimPerson();
            usuario.setName(name);
            usuario.setEmail(email);
            dimPersonRepository.save(usuario);
        }
        return usuario;
    }

    @Override
    @Transactional
    public DimAccess NewDimAccess(Date date) {

        DimAccess dimAccess = new DimAccess();
        dimAccess.setDate(date);
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
        // factAccessDate.setTime_access(time_access);
        // factAccessDate.setDimAccess(dimAccess);
        // factAccessDate.setDimPermission(dimPermission);
        // factAccessDate.setQty_access(qty_access);
        // FactAccessDateRepo.save(factAccessDate);

        return factAccessDate;
    }

}
