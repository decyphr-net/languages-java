package com.decyphr.languages.languages;

import java.util.List;

import org.springframework.stereotype.Component;

import com.decyphr.languages.languages.dto.LanguageEntity;

@Component
public class LanguagesDAL {
    LanguagesDatabaseRepository languageDatabaseRepository;
    LanguagesCacheRepository languagesCacheRepository;

    public LanguagesDAL(
            LanguagesDatabaseRepository languageDatabaseRepository,
            LanguagesCacheRepository languagesCacheRepository) {
        this.languageDatabaseRepository = languageDatabaseRepository;
        this.languagesCacheRepository = languagesCacheRepository;
    }

    /**
     * Get all languages
     *
     * If the languages can be retrieved from the in-memory cache, then return those,
     * otherwise, retrieve the data from the DB and return it
     *
     * @return List<LanguageEntity>
     */
    public List<LanguageEntity> getAllLanguages() {
        List<LanguageEntity> languages = null;

        try {
            languages = languagesCacheRepository.getAllLanguages();
        } catch (Exception e) {
            languages = languageDatabaseRepository.getAllLanguages();
        }
        
        if (languages == null) {
            languages = languageDatabaseRepository.getAllLanguages();
        }
        
        return languages;
    }

    /**
     * Get language by code or short code
     *
     * Check the in-memory cache and if the value is present, return it, otherwise,
     * retrieve from the DB and return it
     *
     * @param codeOrShortCode - Either the language code (for example `en-GB`), or the
     *      short code (i.e. `en`)
     * @return LanguageEntity
     */
    public LanguageEntity getLanguageByCodeOrShortCode(String codeOrShortCode) {
        LanguageEntity language = languagesCacheRepository.getLanguageByCodeOrShortCode(
                codeOrShortCode);
        
        if (language == null) {
            language = languageDatabaseRepository.getLanguageByCodeOrShortCode(
                    codeOrShortCode);
        }
        return language;
    }

    /**
     * Get language by the ID
     * 
     * Check the in-memory cache and if the value is present, return it, otherwise,
     * retrieve from the DB and return it
     * 
     * @param id - The ID of the language to retreive
     * @return LanguageEntity
     */
    public LanguageEntity getLanguageById(int id) {
        LanguageEntity language = languagesCacheRepository.getLanguageById(id);
        
        if (language == null) {
            language = languageDatabaseRepository.getLanguageById(id);
        }
        return language;
    }
}
