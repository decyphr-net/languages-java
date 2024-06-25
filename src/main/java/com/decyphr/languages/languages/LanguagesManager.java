package com.decyphr.languages.languages;

import java.util.List;

import org.springframework.stereotype.Component;

import com.decyphr.languages.languages.dto.LanguageModel;

@Component
public class LanguagesManager {

    LanguagesRepository languageRepository;

    public LanguagesManager(LanguagesRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
    
    public List<LanguageModel> getAllLanguages() {
        return languageRepository.getAllLanguages();
    }

    public LanguageModel getLanguageBasedOnCodeOrShortCode(String codeOrShortCode) {
        return languageRepository.getLanguageBasedOnCodeOrShortCode(codeOrShortCode);
    }
}
