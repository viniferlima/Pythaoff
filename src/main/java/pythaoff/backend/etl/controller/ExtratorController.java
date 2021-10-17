package pythaoff.backend.etl.controller;

import java.util.HashSet;

import javax.sql.rowset.serial.SerialArray;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
import pythaoff.backend.etl.Entity.DimGrade;
import pythaoff.backend.etl.Entity.DimPermission;
import pythaoff.backend.etl.Entity.DimPerson;
import pythaoff.backend.etl.Repository.AccessRepository;
import pythaoff.backend.etl.Repository.DimAccessRepository;
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
    PythaoffServices servicesRepo;

    @Autowired
    DimAccessRepository dimAccessRepository;

    @Transactional
    @GetMapping(value = "/acessos")
    public String getAcessos() {
        String jsonString = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            jsonString = mapper.writeValueAsString(accessRepository.findAll());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    @PostMapping(value = "/notaRegister")
    public ResponseEntity<Object> notaRegister(@RequestBody final String formData) {

        // matriculaRep.save()
        // registrar data

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Transactional
    @PostMapping(value = "/matriculaRegister")
    public ResponseEntity<Object> matriculaRegister(@RequestBody final String formData) {

        // matriculaRep.save()
        // registrar data

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Transactional
    @PostMapping(value = "/loginRegister")
    public ResponseEntity<Object> loginRegister(@RequestBody final String formData) {

        System.out.println(formData);

        JSONObject loginLogJson = new JSONObject(formData);
        Access acesso = new Access();

        if (loginLogJson.has("datahora")) {
            acesso.setDateFromString(loginLogJson.getString("datahora"));
            servicesRepo.NewDimAccess(loginLogJson.getString("datahora"));

        }
        if (loginLogJson.has("usuario") && loginLogJson.has("permissao") && loginLogJson.has("email")) {
            acesso.setPerson(servicesRepo.NewPerson(loginLogJson.getString("usuario"), loginLogJson.getString("email"),
                    loginLogJson.getString("permissao")));

        }

        acesso = accessRepository.save(acesso);

        if (acesso == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.OK);

    }

    public Person registerUser(String username, String email, String type) {
        Person usuario = personRepository.findByName(username);
        if (usuario == null) {
            usuario = new Person();
            usuario.setName(username);
            usuario.setEmail(email);
            usuario.setPermission(servicesRepo.NewPermission(type));
            usuario.setAccesses(new HashSet<Access>());
            usuario.setRegistrations(new HashSet<Registration>());
            usuario = personRepository.save(usuario);
            System.out.println("Gerando usuário.");
        }
        System.out.println("Usuário: " + usuario.toString());

        DimPerson dimPerson = servicesRepo.NewDimPerson(username, email);
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

        DimPermission dimPermission = servicesRepo.NewDimPermission(type);
        System.out.println("Dim Permissão: " + dimPermission.toString());

        return permissao;
    }

    public Grade registerGrade(Long id, Registration registration) {

        Grade grade = servicesRepo.NewGrade(id, registration);
        System.out.println("Gerando grade.");
        System.out.println("Grade: " + grade.toString());

        DimGrade dimGrade = servicesRepo.NewDimGrade(grade.getId());
        System.out.println("Dim Grade: " + dimGrade.toString());

        return grade;
    }

}
