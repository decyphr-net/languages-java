package com.decyphr.languages.health;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.decyphr.languages.health.dto.HealthStatus;

@RestController
@RequestMapping("/api/ping")
public class HealthController {
    
    @GetMapping(produces = "application/json")
    public ResponseEntity<HealthStatus> healthCheck() {
        HealthStatus entities = new HealthStatus(true, "OK");
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }
}
