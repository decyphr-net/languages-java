package com.decyphr.languages.languages;

import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.decyphr.languages.languages.dto.LanguageEntity;

@RestController
@RequestMapping()
public class LanguagesController {
    LanguagesManager languagesManager;

    public LanguagesController(LanguagesManager languagesManager) {
        this.languagesManager = languagesManager;
    }
    
    @GetMapping(path = "/api/languages", produces = "application/json")
    public ResponseEntity<List<LanguageEntity>> getLanguages() {
		List<LanguageEntity> languages = languagesManager.getAllLanguages();
        return new ResponseEntity<List<LanguageEntity>>(languages, HttpStatus.OK);
    }

    @GetMapping(path = "/api/language", produces = "application/json")
    public ResponseEntity<LanguageEntity> getLanguage(
            @RequestParam(required = true) Map<String, String> params) {

        LanguageEntity language = languagesManager.getLanguageByCodeOrShortCode(
                params.get("code"));

        if (language == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(language, HttpStatus.OK);
    }

    @GetMapping(path = "/api/language/{id}")
    public ResponseEntity<LanguageEntity> getLanguageById(
            @PathVariable(required=true, name="id") int id) {
        System.out.println(id);
        LanguageEntity language = languagesManager.getLanguageById(id);

        if (language == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(language, HttpStatus.OK);
    }
}
