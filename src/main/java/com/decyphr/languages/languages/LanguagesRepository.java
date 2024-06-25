package com.decyphr.languages.languages;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.decyphr.languages.languages.dto.LanguageModel;

@Component
public class LanguagesRepository {

    JdbcTemplate jdbcTemplate;

    public LanguagesRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<LanguageModel> getAllLanguages() {
        String sql = "SELECT id, name, code, short_code FROM languages";
		return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(
                    LanguageModel.class));
    }
}
