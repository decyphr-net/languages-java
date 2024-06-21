package com.decyphr.languages.health;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ping")
public class Controller {
    
    @GetMapping(produces = "application/json")
    public ResponseEntity<Entities> healthCheck() {
        Entities entities = new Entities(true, "OK");
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }
}
