package pythaoff.backend.etl.controller;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/extrator")
public class ExtratorController {
    
    @PostMapping(value ="/loginRegister")
    public ResponseEntity<Object> loginRegister(@RequestBody final String formData) {

        System.out.println(formData);
        // final JSONObject obj = new JSONObject(formData);

        return new ResponseEntity<Object>(formData, HttpStatus.OK);
    }

}
