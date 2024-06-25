package com.decyphr.languages.languages;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.decyphr.languages.languages.dto.LanguageModel;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
    JdbcTemplate jdbcTemplate;

    public LanguagesController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<LanguageModel>> getLanguages() {
        String sql = "SELECT id, name, code, short_code FROM languages";
		List<LanguageModel> languages = //jdbcTemplate.query(sq)
                jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(
                    LanguageModel.class));
        return new ResponseEntity<List<LanguageModel>>(languages, HttpStatus.OK);
    }
}