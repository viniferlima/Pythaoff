package pythaoff.backend.etl.Entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "factAccessDate")
public class FactRegistrationGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fact")
    private Long id_fact;

    @Column(name = "dimCourseClass_name")
    private String dimCourseClassName;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @Column(name = "dimCourseClass_startDate")
    private Date courseClassStartDate;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @Column(name = "dimCourseClass_endDate")
    private Date courseClassEndDate;

    //----------------------------------------------------------------

    @Column(name = "registration_code")
    private Long registrationId;

    //----------------------------------------------------------------

    @Column(name = "dimCourse_name")
    private String courseName;

    @Column(name = "dimCourse_description")
    private String courseDescription;

    //----------------------------------------------------------------

    @Column(name = "dimPerson_name")
    private String personName;

    @Column(name = "dimPerson_email")
    private String personEmail;

    //----------------------------------------------------------------

    @Column(name = "dimGrade_grade")
    private Long grade;

    //----------------------------------------------------------------

    @Column(name = "dimPermission_typePermission")
    private String permissionType;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "dimCourseClass_id")
    private DimCourseClass dimCourseClass;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "registration_id")
    private DimRegistration dimRegistration;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "dimCourse_id")
    private DimCourse dimCourse;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "dimPerson_id")
    private DimPerson dimPerson;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "dimGrade_id")
    private DimGrade dimGrade;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "dimPermission_id")
    private DimPermission dimPermission;
    
    public Long getId_fact() {
        return id_fact;
    }

    public void setId_fact(Long id_fact) {
        this.id_fact = id_fact;
    }

    public String getDimCourseClassName() {
        return dimCourseClassName;
    }

    public void setDimCourseClassName(String dimCourseClassName) {
        this.dimCourseClassName = dimCourseClassName;
    }

    public Date getCourseClassStartDate() {
        return courseClassStartDate;
    }

    public void setCourseClassStartDate(Date courseClassStartDate) {
        this.courseClassStartDate = courseClassStartDate;
    }

    public Date getCourseClassEndDate() {
        return courseClassEndDate;
    }

    public void setCourseClassEndDate(Date courseClassEndDate) {
        this.courseClassEndDate = courseClassEndDate;
    }

    public Long getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Long registrationId) {
        this.registrationId = registrationId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }

    public Long getGrade() {
        return grade;
    }

    public void setGrade(Long grade) {
        this.grade = grade;
    }

    public String getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(String permissionType) {
        this.permissionType = permissionType;
    }

    public DimCourseClass getDimCourseClass() {
        return dimCourseClass;
    }

    public void setDimCourseClass(DimCourseClass dimCourseClass) {
        this.dimCourseClass = dimCourseClass;
    }

    public DimRegistration getDimRegistration() {
        return dimRegistration;
    }

    public void setDimRegistration(DimRegistration dimRegistration) {
        this.dimRegistration = dimRegistration;
    }

    public DimCourse getDimCourse() {
        return dimCourse;
    }

    public void setDimCourse(DimCourse dimCourse) {
        this.dimCourse = dimCourse;
    }

    public DimPerson getDimPerson() {
        return dimPerson;
    }

    public void setDimPerson(DimPerson dimPerson) {
        this.dimPerson = dimPerson;
    }

    public DimGrade getDimGrade() {
        return dimGrade;
    }

    public void setDimGrade(DimGrade dimGrade) {
        this.dimGrade = dimGrade;
    }

    public DimPermission getDimPermission() {
        return dimPermission;
    }

    public void setDimPermission(DimPermission dimPermission) {
        this.dimPermission = dimPermission;
    }

    

    public FactRegistrationGrade(Long id_fact, String dimCourseClassName, Date courseClassStartDate,
            Date courseClassEndDate, Long registrationId, String courseName, String courseDescription,
            String personName, String personEmail, Long grade, String permissionType, DimCourseClass dimCourseClass,
            DimRegistration dimRegistration, DimCourse dimCourse, DimPerson dimPerson, DimGrade dimGrade,
            DimPermission dimPermission) {
        this.id_fact = id_fact;
        this.dimCourseClassName = dimCourseClassName;
        this.courseClassStartDate = courseClassStartDate;
        this.courseClassEndDate = courseClassEndDate;
        this.registrationId = registrationId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.personName = personName;
        this.personEmail = personEmail;
        this.grade = grade;
        this.permissionType = permissionType;
        this.dimCourseClass = dimCourseClass;
        this.dimRegistration = dimRegistration;
        this.dimCourse = dimCourse;
        this.dimPerson = dimPerson;
        this.dimGrade = dimGrade;
        this.dimPermission = dimPermission;
    }

    public FactRegistrationGrade(){};
    
}
