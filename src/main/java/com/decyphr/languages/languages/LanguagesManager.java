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
    
    public List<LanguageEntity> getAllLanguages() {
        return languagesDal.getAllLanguages();
    }

    public LanguageEntity getLanguageByCodeOrShortCode(String codeOrShortCode) {
        return languagesDal.getLanguageByCodeOrShortCode(codeOrShortCode);
    }

    public LanguageEntity getLanguageById(int id) {
        return languagesDal.getLanguageById(id);
    }

    public void populateLanguageCache() {
        languagesSingleton.setLanguages(getAllLanguages());
    }
}
