package pythaoff.backend.etl.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pythaoff.backend.etl.Repository.AccessRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/dashboard")
public class DashboardController {

    @Autowired
    AccessRepository accessRepository;

    @GetMapping("/notas")
    public String getNotas(@RequestParam(name="name", required = false, defaultValue = "Ahmed") String matricula) {
        String jsonString = "";        
        ObjectMapper mapper = new ObjectMapper(); 
        try {
            jsonString = mapper.writeValueAsString(accessRepository.findAllByOrderByDate());;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } 
        return jsonString;
    }

    @GetMapping("/acessos")
    public String getAcessos() {
        String jsonString = "";        
        ObjectMapper mapper = new ObjectMapper(); 
        try {
            jsonString = mapper.writeValueAsString(accessRepository.findAllByOrderByDate());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } 
        return jsonString;
    }
   
}
