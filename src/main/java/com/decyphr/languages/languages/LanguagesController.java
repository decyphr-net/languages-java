package com.decyphr.languages.languages;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.decyphr.languages.languages.dto.LanguageEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping()
public class LanguagesController {
    LanguagesManager languagesManager;

    public LanguagesController(LanguagesManager languagesManager) {
        this.languagesManager = languagesManager;
    }
    
    /**
     * Get all languages and return them
     * 
     * Example Usage:
     *      curl --request GET --url http://127.0.0.1:8080/api/languages
     * 
     * Example Response:
     *      [
     *          {
     *              "id": 1,
     *              "name": "English",
     *              "code": "en-GB",
     *              "shortCode": "en"
     *          }
     *      ]
     * 
     * @return ResponseEntity<List<LanguageEntity>>
     */
    @GetMapping(path = "/api/languages", produces = "application/json")
    public ResponseEntity<List<LanguageEntity>> getLanguages() {
        log.info("Getting languages");
		List<LanguageEntity> languages = languagesManager.getAllLanguages();
        return new ResponseEntity<List<LanguageEntity>>(languages, HttpStatus.OK);
    }

    /**
     * Get langauge by code or short code
     *
     * Example Usage:
     *      curl --request GET --url http://127.0.0.1:8080/api/language?code=en
     *
     * Example Response:
     *      {
     *          "id": 1,
     *          "name": "English",
     *          "code": "en-GB",
     *          "shortCode": "en"
     *      }
     * 
     * @return ResponseEntity<LanguageEntity>
     */
    @GetMapping(path = "/api/language", produces = "application/json")
    public ResponseEntity<LanguageEntity> getLanguageByCodeOrShortCode(
            @RequestParam(required = true) Map<String, String> params) {

        LanguageEntity language = languagesManager.getLanguageByCodeOrShortCode(
                params.get("code"));

        if (language == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(language, HttpStatus.OK);
    }

    /**
     * Get langauge by ID
     *
     * Example Usage:
     *      curl --request GET --url http://127.0.0.1:8080/api/language/1
     *
     * Example Response:
     *      {
     *          "id": 1,
     *          "name": "English",
     *          "code": "en-GB",
     *          "shortCode": "en"
     *      }
     * 
     * @return ResponseEntity<LanguageEntity>
     */
    @GetMapping(path = "/api/language/{id}")
    public ResponseEntity<LanguageEntity> getLanguageById(
            @PathVariable(required=true, name="id") int id) {
        LanguageEntity language = languagesManager.getLanguageById(id);

        if (language == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(language, HttpStatus.OK);
    }
}
