package com.decyphr.languages.languages;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import org.springframework.stereotype.Component;

import com.decyphr.languages.languages.dto.LanguageEntity;

@Component
public class LanguagesSingleton {
    
    private static LanguagesSingleton instance;
    @Getter
    @Setter
    private List<LanguageEntity> languages = null;
    
    private LanguagesSingleton() { }

    public static LanguagesSingleton getInstance() {
        if (instance == null) {
            instance = new LanguagesSingleton();
        }

        return instance;
    }

    /**
     * Get language by code or short code.
     *
     * Try to filter out the language that matches either the code, or shortCode
     * provided. If none is found, return null
     *
     * @param codeOrShortCode
     * @return LanguageEntity
     */
    public LanguageEntity getLanguageByCodeOrShortCode(String codeOrShortCode) {
        for (LanguageEntity language : languages) {
            if (
                    language.getCode() == codeOrShortCode 
                    || language.getShortCode() == codeOrShortCode) {
                return language;
            } else {
                continue;
            }
        }

        return null;
    }

    /**
     * Get language by ID.
     *
     * Try to filter out the language that matches the ID provided. If none is found, 
     * return null
     *
     * @param id
     * @return LanguageEntity
     */
    public LanguageEntity getLanguageById(int id) {
        for (LanguageEntity language : languages) {
            if (language.getId() == id) {
                return language;
            } else {
                continue;
            }
        }

        return null;
    }
}
