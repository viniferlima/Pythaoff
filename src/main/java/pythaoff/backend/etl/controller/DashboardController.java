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
import pythaoff.backend.etl.Repository.FactAccessDateRepository;
import pythaoff.backend.etl.Repository.FactRegistrationGradeRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/dashboard")
public class DashboardController {

    @Autowired
    AccessRepository accessRepository;

    @Autowired
    FactAccessDateRepository factAccessDateRepository;

    @Autowired
    FactRegistrationGradeRepository factRegistrationGradeRepository;

    @GetMapping(value = "/quantidadeacessos")
    public String getCountAcessos() {
        // String jsonString = "";
        // ObjectMapper mapper = new ObjectMapper();
        // try {
        //     jsonString = mapper.writeValueAsString(accessRepository.findAll());
        // } catch (JsonProcessingException e) {
        //     e.printStackTrace();
        // }

        String jsonString = String.format("{\"count\" : %d}", factAccessDateRepository.count());
        return jsonString;
    }

    @GetMapping("/notas")
    public String getNotas(@RequestParam() String curso) {
        String jsonString = "";        
        ObjectMapper mapper = new ObjectMapper(); 
        try {
            if (curso.length() == 0) {
                jsonString = mapper.writeValueAsString(factRegistrationGradeRepository.findAllByCourseName(curso));
            } else {
                jsonString = mapper.writeValueAsString(factRegistrationGradeRepository.findAll());    
            }
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
            jsonString = mapper.writeValueAsString(factAccessDateRepository.findAllByOrderByAccessDate());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } 
        return jsonString;
    }
   
}
