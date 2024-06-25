package com.decyphr.languages.languages;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.decyphr.languages.languages.dto.LanguageModel;

@Component
public class LanguagesManager {

    LanguagesRepository languageRepository;
    LanguagesSingleton languagesSingleton = LanguagesSingleton.getInstance();

    public LanguagesManager(LanguagesRepository languageRepository) {
        this.languageRepository = languageRepository;

    }
    
    public List<LanguageModel> getAllLanguages() {
        List<LanguageModel> languages = null;

        try {
            languages = languagesSingleton.getLanguages();
        } catch (Exception e) {
            languages = languageRepository.getAllLanguages();
        }
        
        if (languages == null) {
            languages = languageRepository.getAllLanguages();
        }
        
        return languages;
    }

    public LanguageModel getLanguageBasedOnCodeOrShortCode(String codeOrShortCode) {
        return languageRepository.getLanguageBasedOnCodeOrShortCode(codeOrShortCode);
    }

    public void populateLanguageCache() {
        languagesSingleton.setLanguages(getAllLanguages());
    }
}
