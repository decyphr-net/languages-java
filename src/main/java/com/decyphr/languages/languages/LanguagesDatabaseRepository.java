package com.decyphr.languages.languages;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.dao.EmptyResultDataAccessException;

import com.decyphr.languages.languages.dto.LanguageEntity;

@Component
public class LanguagesDatabaseRepository {

    JdbcTemplate jdbcTemplate;

    public LanguagesDatabaseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Retrieve all languages
     *
     * @return
     */
    public List<LanguageEntity> getAllLanguages() {
        String sql = "SELECT id, name, code, short_code FROM languages";
		return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(
                    LanguageEntity.class));
    }

    /**
     * Get and return a single language by whatever where clause value is provided
     *
     * @param sql - SQL query
     * @param whereValue - value to be injected into the query
     * @return
     */
    private LanguageEntity getSingleLanguage(String sql, Object whereValue) {
        try {
            return jdbcTemplate.queryForObject(
                    sql, 
                    BeanPropertyRowMapper.newInstance(LanguageEntity.class), 
                    whereValue);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    /**
     * Get and return a single language by its code
     *
     * @param code
     * @return
     */
    private LanguageEntity getLanguageBasedOnCode(String code) {
        return getSingleLanguage(
            "SELECT id, name, code, short_code FROM languages WHERE code=?",
            code
        );
    }

    /**
     * Get and return a single language by its shortCode
     *
     * @param id
     * @return
     */
    private LanguageEntity getLanguageBasedOnShortCode(String shortCode) {
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
    public LanguageEntity getLanguageByCodeOrShortCode(String codeOrShortCode) {
        LanguageEntity language = getLanguageBasedOnCode(codeOrShortCode);

        if (language == null) {
            language = getLanguageBasedOnShortCode(codeOrShortCode);
        }

        return language;
    }

    /**
     * Get and return a single language by its ID
     *
     * @param id
     * @return
     */
    public LanguageEntity getLanguageById(int id) {
        return getSingleLanguage(
            "SELECT id, name, code, short_code FROM languages WHERE id=?", id
        );
    }
}
