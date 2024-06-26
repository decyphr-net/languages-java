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

    public LanguageEntity getLanguageByCodeOrShortCode(String codeOrShortCode) {
        LanguageEntity language = languagesCacheRepository.getLanguageByCodeOrShortCode(
                codeOrShortCode);
        
        if (language == null) {
            language = languageDatabaseRepository.getLanguageByCodeOrShortCode(
                    codeOrShortCode);
        }
        return language;
    }

    public LanguageEntity getLanguageById(int id) {
        LanguageEntity language = languagesCacheRepository.getLanguageById(id);
        
        if (language == null) {
            language = languageDatabaseRepository.getLanguageById(id);
        }
        return language;
    }
}
