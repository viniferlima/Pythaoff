package pythaoff.backend.etl.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pythaoff.backend.etl.Repository.AccessRepository;
import pythaoff.backend.etl.Repository.PermissionRepository;
import pythaoff.backend.etl.Repository.PersonRepository;
import pythaoff.backend.etl.model.Access;
import pythaoff.backend.etl.model.Permission;
import pythaoff.backend.etl.model.Person;

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
    
    @Transactional
    @PostMapping(value ="/notaRegister")
    public ResponseEntity<Object> notaRegister(@RequestBody final String formData) {

        //matriculaRep.save()
        //registrar data

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Transactional
    @PostMapping(value ="/matriculaRegister")
    public ResponseEntity<Object> matriculaRegister(@RequestBody final String formData) {

        //matriculaRep.save()
        //registrar data

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Transactional
    @PostMapping(value ="/loginRegister")
    public ResponseEntity<Object> loginRegister(@RequestBody final String formData) {

        System.out.println(formData);

        JSONObject loginLogJson = new JSONObject(formData);
        Access acesso = new Access();

        if (loginLogJson.has("datahora")){
            acesso.setDateFromString(loginLogJson.getString("datahora"));
        }
        if (loginLogJson.has("usuario") && loginLogJson.has("permissao")){
            acesso.setPerson(registerUser(loginLogJson.getString("usuario"),loginLogJson.getString("permissao")));
        }
        
        acesso = accessRepository.save(acesso);

        if (acesso == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    public Person registerUser(String username, String type) {
        Person usuario = personRepository.findFirstByNome(username);
        if (usuario == null) {
            usuario = new Person();
            usuario.setNome(username);
            usuario.setPermission(registerPermission(type));
            usuario = personRepository.save(usuario);
            System.out.println("Gerando usuário.");
        }
        System.out.println("Usuário: " + usuario.toString());
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
        return permissao;
    }

}
