package com.decyphr.languages.languages;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.decyphr.languages.languages.dto.LanguageModel;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
    LanguagesManager languagesManager;

    public LanguagesController(LanguagesManager languagesManager) {
        this.languagesManager = languagesManager;
    }
    
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<LanguageModel>> getLanguages() {
		List<LanguageModel> languages = languagesManager.getAllLanguages();
        return new ResponseEntity<List<LanguageModel>>(languages, HttpStatus.OK);
    }
}
