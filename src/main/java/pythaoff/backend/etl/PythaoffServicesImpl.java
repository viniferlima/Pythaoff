package pythaoff.backend.etl;

import java.util.Date;
import java.util.HashSet;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pythaoff.backend.etl.Entity.DimAccess;
import pythaoff.backend.etl.Entity.DimCourse;
import pythaoff.backend.etl.Entity.DimCourseClass;
import pythaoff.backend.etl.Entity.DimGrade;
import pythaoff.backend.etl.Entity.DimPermission;
import pythaoff.backend.etl.Entity.DimPerson;
import pythaoff.backend.etl.Entity.DimRegistration;
import pythaoff.backend.etl.Entity.FactAccessDate;
import pythaoff.backend.etl.Entity.FactRegistrationGrade;
import pythaoff.backend.etl.Repository.AccessRepository;
import pythaoff.backend.etl.Repository.CourseClassRepository;
import pythaoff.backend.etl.Repository.CourseRepository;
import pythaoff.backend.etl.Repository.DimAccessRepository;
import pythaoff.backend.etl.Repository.DimCourseClassRepository;
import pythaoff.backend.etl.Repository.DimCourseRepository;
import pythaoff.backend.etl.Repository.DimGradeRepository;
import pythaoff.backend.etl.Repository.DimPermissionRepository;
import pythaoff.backend.etl.Repository.DimPersonRepository;
import pythaoff.backend.etl.Repository.DimRegistrationRepository;
import pythaoff.backend.etl.Repository.FactAccessDateRepository;
import pythaoff.backend.etl.Repository.FactRegistrationGradeRepository;
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

    @Autowired
    private DimCourseRepository dimCourseRepository;

    @Autowired
    private DimCourseClassRepository dimCourseClassRepository;

    @Autowired
    DimRegistrationRepository dimRegistrationRepository;

    @Autowired
    FactRegistrationGradeRepository factRegistrationGradeRepository;

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
            usuario.setRegistrations(new HashSet<Registration>());
            personRepo.save(usuario);
        }

        // newDimPerson(name, email);

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
    public Grade NewGrade(Long id, Double value) {
        Grade grade = gradeRepository.findByRegistrationId(id);
        if (grade == null) {
            grade = new Grade();
            // grade.setRegistration(NewRegistration(registration.getPerson(), registration.getCourseClass()));
            gradeRepository.save(grade);

        }

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
    public DimGrade newDimGrade(Double grade) {
        DimGrade dimGrade = new DimGrade(); 
        if (grade == null) {
            dimGrade = new DimGrade();
            dimGrade.setGrade(grade);
            dimGradeRepository.save(dimGrade);
        }
        return dimGrade;
    }

    @Override
    @Transactional
    public DimPerson newDimPerson(String name, String email) {
        DimPerson usuario = dimPersonRepository.findByName(name);
        if (usuario == null) {
            usuario = new DimPerson();
            usuario.setName(name);
            usuario.setEmail(email);
            usuario.setFactAccessDate(new HashSet<FactAccessDate>());
            dimPersonRepository.save(usuario);
        }
        return usuario;
    }

    @Override
    @Transactional
    public DimAccess newDimAccess(String date) {

        DimAccess dimAccess = new DimAccess();
        dimAccess.setDateFromString(date);
        dimAccess.setFactAccessDate(new HashSet<FactAccessDate>());
        dimAccessRepo.save(dimAccess);

        return dimAccess;
    }

    @Override
    @Transactional
    public DimPermission newDimPermission(String type_permission) {
        DimPermission dimPermission = dimPermissionRepo.findByType(type_permission);
        if (dimPermission == null) {
            dimPermission = new DimPermission();
            dimPermission.setType_permission(type_permission);
            dimPermission.setFactAccessDate(new HashSet<FactAccessDate>());
            dimPermissionRepo.save(dimPermission);
        }
        return dimPermission;
    }

    public DimCourse newDimCourse(String name, String description){
        DimCourse dimCourse = new DimCourse();
        dimCourse.setName(name);
        dimCourse.setDescription(description);
        dimCourseRepository.save(dimCourse);

        return dimCourse;
    };

    public DimCourseClass newDimCourseClass(String name, Date startDate, Date endDate){
        DimCourseClass dimCourseClass = new DimCourseClass();
        dimCourseClass.setName(name);
        dimCourseClass.setStartDate(startDate);
        dimCourseClass.setEndDate(endDate);
        dimCourseClassRepository.save(dimCourseClass);

        return dimCourseClass;
    };

    public DimRegistration newDimRegistration(Long id){
        DimRegistration dimRegistration = new DimRegistration(id);
        dimRegistrationRepository.save(dimRegistration);

        return dimRegistration;
    };

    
    @Override
    @Transactional
    public FactAccessDate newFactAccessDate(String personName, String personEmail, Date accessDate, String permissionType,
            DimAccess dimAccess, DimPerson dimPerson, DimPermission dimPermission) {

        FactAccessDate factAccessDate = new FactAccessDate(personName, personEmail, accessDate, permissionType,
                                                            dimAccess, dimPerson, dimPermission);
        FactAccessDateRepo.save(factAccessDate);
        return factAccessDate;
    }

    @Transactional
    public FactRegistrationGrade newFactRegistrationGrade(String dimCourseClassName, Date courseClassStartDate,
            Date courseClassEndDate, Long registrationId, String courseName, String courseDescription,
            String personName, String personEmail, Double grade, String permissionType, DimCourseClass dimCourseClass,
            DimRegistration dimRegistration, DimCourse dimCourse, DimPerson dimPerson, DimGrade dimGrade,
            DimPermission dimPermission){

        FactRegistrationGrade factRegistrationGrade = new FactRegistrationGrade(dimCourseClassName, courseClassStartDate,
            courseClassEndDate, registrationId, courseName, courseDescription, personName, personEmail, grade, permissionType,
            dimCourseClass, dimRegistration, dimCourse, dimPerson, dimGrade, dimPermission);

        factRegistrationGradeRepository.save(factRegistrationGrade);
        return factRegistrationGrade;
    };

}
