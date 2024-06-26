package com.decyphr.languages.languages;

import java.util.List;

import org.springframework.stereotype.Component;

import com.decyphr.languages.languages.dto.LanguageEntity;

@Component
public class LanguagesCacheRepository implements ILanguagesRepository {
    LanguagesSingleton languagesSingleton = LanguagesSingleton.getInstance();

    public List<LanguageEntity> getAllLanguages() {
        return languagesSingleton.getLanguages();
    }

    public LanguageEntity getLanguageByCodeOrShortCode(String codeOrShortCode) {
        return languagesSingleton.getLanguageByCodeOrShortCode(codeOrShortCode);
    }

    public LanguageEntity getLanguageById(int id) {
        System.out.println(languagesSingleton.getLanguages());
        return languagesSingleton.getLanguageById(id);
    }
}
