package com.decyphr.languages.languages;

import java.util.List;

import org.springframework.stereotype.Component;

import com.decyphr.languages.languages.dto.LanguageEntity;

@Component
public class LanguagesCacheRepository implements ILanguagesRepository {
    LanguagesSingleton languagesSingleton = LanguagesSingleton.getInstance();

    /**
     * Retrieve all languages
     *
     * @return
     */
    public List<LanguageEntity> getAllLanguages() {
        return languagesSingleton.getLanguages();
    }

    /**
     * Get and return a single language by its code or short code
     *
     * @param codeOrShortCode
     * @return
     */
    public LanguageEntity getLanguageByCodeOrShortCode(String codeOrShortCode) {
        return languagesSingleton.getLanguageByCodeOrShortCode(codeOrShortCode);
    }

    /**
     * Get and return a single language by its ID
     *
     * @param id
     * @return
     */
    public LanguageEntity getLanguageById(int id) {
        return languagesSingleton.getLanguageById(id);
    }
}
