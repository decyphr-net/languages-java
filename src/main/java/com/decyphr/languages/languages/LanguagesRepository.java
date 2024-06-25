package com.decyphr.languages.languages;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.dao.EmptyResultDataAccessException;

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

    private LanguageModel getSingleLanguage(String sql, String whereValue) {
        try {
            return jdbcTemplate.queryForObject(
                    sql, 
                    BeanPropertyRowMapper.newInstance(LanguageModel.class), 
                    whereValue);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    private LanguageModel getLanguageBasedOnCode(String code) {
        return getSingleLanguage(
            "SELECT id, name, code, short_code FROM languages WHERE code=?",
            code
        );
    }

    private LanguageModel getLanguageBasedOnShortCode(String shortCode) {
        return getSingleLanguage(
            "SELECT id, name, code, short_code FROM languages WHERE short_code=?",
            shortCode
        );
    }

    /**
     * Get a language from the DB based on the code provided. This might be a normal
     * language code, or a short language code. If a language with the provided code is
     * not found, then query for a language with the same short code. If no language is
     * found in either case, return null
     * @param codeOrShortCode
     * @return
     */
    public LanguageModel getLanguageBasedOnCodeOrShortCode(String codeOrShortCode) {
        LanguageModel language = getLanguageBasedOnCode(codeOrShortCode);

        if (language == null) {
            language = getLanguageBasedOnShortCode(codeOrShortCode);
        }

        return language;
    }
}
