package com.decyphr.languages.languages;

import java.util.List;

import org.springframework.stereotype.Component;

import com.decyphr.languages.languages.dto.LanguageEntity;

@Component
public class LanguagesManager {

    LanguagesDAL languagesDal;
    LanguagesSingleton languagesSingleton = LanguagesSingleton.getInstance();

    public LanguagesManager(LanguagesDAL languagesDal) {
        this.languagesDal = languagesDal;
    }
    
    /**
     * Get and return all languages
     *
     * @return
     */
    public List<LanguageEntity> getAllLanguages() {
        return languagesDal.getAllLanguages();
    }

    /**
     * Get and return a single language by its code or short code
     *
     * @param codeOrShortCode
     * @return
     */
    public LanguageEntity getLanguageByCodeOrShortCode(String codeOrShortCode) {
        return languagesDal.getLanguageByCodeOrShortCode(codeOrShortCode);
    }

    /**
     * Get and return a single language by its ID
     * @param id
     * @return
     */
    public LanguageEntity getLanguageById(int id) {
        return languagesDal.getLanguageById(id);
    }

    /**
     * Populate the internal cache with all of the languages
     */
    public void populateLanguageCache() {
        languagesSingleton.setLanguages(getAllLanguages());
    }
}
