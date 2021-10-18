package pythaoff.backend.etl.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pythaoff.backend.etl.PythaoffServices;
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
import pythaoff.backend.etl.Repository.DimAccessRepository;
import pythaoff.backend.etl.Repository.FactAccessDateRepository;
import pythaoff.backend.etl.Repository.PermissionRepository;
import pythaoff.backend.etl.Repository.PersonRepository;
import pythaoff.backend.etl.model.Access;
import pythaoff.backend.etl.model.Grade;
import pythaoff.backend.etl.model.Permission;
import pythaoff.backend.etl.model.Person;
import pythaoff.backend.etl.model.Registration;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/extrator")
public class ExtratorController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PermissionRepository permissionRepository;

    @Autowired
    AccessRepository accessRepository;

    @Autowired
    PythaoffServices pythaoffServices;

    @Autowired
    DimAccessRepository dimAccessRepository;

    @Autowired
    FactAccessDateRepository factAccessDateRepository;

    @PostMapping(value = "/notaRegister")
    public ResponseEntity<Object> notaRegister(@RequestBody final String formData) throws JSONException, ParseException {

        JSONObject logJson = new JSONObject(formData);

        
        FactRegistrationGrade factRegistrationGrade = pythaoffServices.newFactRegistrationGrade(logJson.getString("dimCourseClassName"), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(logJson.getString("courseClassStartDate")), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(logJson.getString("courseClassEndDate")),
        Long.parseLong(logJson.getString("registrationId")), logJson.getString("courseName"), logJson.getString("courseDescription"), logJson.getString("personName"), logJson.getString("personEmail"), Double.parseDouble(logJson.getString("grade")), logJson.getString("permissionType"),
         new DimCourseClass(), new DimRegistration(Long.parseLong(logJson.getString("registrationId"))), new DimCourse(), new DimPerson(), new DimGrade(), new DimPermission());

        if (factRegistrationGrade == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Transactional
    @PostMapping(value = "/matriculaRegister")
    public ResponseEntity<Object> matriculaRegister(@RequestBody final String formData) {

        JSONObject loginLogJson = new JSONObject(formData);

        // matriculaRep.save()
        // registrar data

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Transactional
    @PostMapping(value = "/loginRegister")
    public ResponseEntity<Object> loginRegister(@RequestBody final String formData) throws JSONException, ParseException {

        System.out.println(formData);

        JSONObject logJson = new JSONObject(formData);

    
        FactAccessDate factAccessDate = pythaoffServices.newFactAccessDate(logJson.getString("personName"), logJson.getString("personEmail"),
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(logJson.getString("accessDate")), logJson.getString("permissionType"), new DimAccess(), new DimPerson(), new DimPermission());

        if (factAccessDate == null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);

        // Access acesso = new Access();

        // if (loginLogJson.has("datahora")) {
        //     acesso.setDateFromString(loginLogJson.getString("datahora"));
        //     pythaoffServices.newDimAccess(loginLogJson.getString("datahora"));

        // }

        // if (loginLogJson.has("usuario") && loginLogJson.has("permissao") && loginLogJson.has("email")) {
        //     acesso.setPerson(pythaoffServices.NewPerson(loginLogJson.getString("usuario"), loginLogJson.getString("email"),
        //             loginLogJson.getString("permissao")));
        // }

        // acesso = accessRepository.save(acesso);

        // if (acesso == null) {
        //     return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        // }

        // return new ResponseEntity<>(HttpStatus.OK);

    }

    public Person registerUser(String username, String email, String type) {
        Person usuario = personRepository.findByName(username);
        if (usuario == null) {
            usuario = new Person();
            usuario.setName(username);
            usuario.setEmail(email);
            usuario.setPermission(pythaoffServices.NewPermission(type));
            usuario.setAccesses(new HashSet<Access>());
            usuario.setRegistrations(new HashSet<Registration>());
            usuario = personRepository.save(usuario);
            System.out.println("Gerando usuário.");
        }
        System.out.println("Usuário: " + usuario.toString());

        DimPerson dimPerson = pythaoffServices.newDimPerson(username, email);
        System.out.println("Dim Usuário: " + dimPerson.toString());

        return usuario;
    }

    public Permission registerPermission(String type) {
        Permission permissao = permissionRepository.findFirstByType(type);
        if (permissao == null) {
            permissao = new Permission();
            permissao.setType(type);
            permissao = permissionRepository.save(permissao);
            System.out.println("Gerando permissao.");
        }
        System.out.println("Permissao: " + permissao.toString());

        DimPermission dimPermission = pythaoffServices.newDimPermission(type);
        System.out.println("Dim Permissão: " + dimPermission.toString());

        return permissao;
    }

    public Grade registerGrade(Long id, Double value) {

        Grade grade = pythaoffServices.NewGrade(id, value);
        System.out.println("Gerando grade.");
        System.out.println("Grade: " + grade.toString());

        DimGrade dimGrade = pythaoffServices.newDimGrade(value);
        System.out.println("Dim Grade: " + dimGrade.toString());

        return grade;
    }

}
