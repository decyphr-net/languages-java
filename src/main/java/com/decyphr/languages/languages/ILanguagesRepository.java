package com.decyphr.languages.languages;

import java.util.List;

import com.decyphr.languages.languages.dto.LanguageEntity;

public interface ILanguagesRepository {

    /**
     * Retrieve all languages
     *
     * @return
     */
    public List<LanguageEntity> getAllLanguages();

    /**
     * Get and return a single language by its code or short code
     *
     * @param codeOrShortCode
     * @return
     */
    public LanguageEntity getLanguageByCodeOrShortCode(String codeOrShortCode);

    /**
     * Get and return a single language by its ID
     *
     * @param id
     * @return
     */
    public LanguageEntity getLanguageById(int id);
}
