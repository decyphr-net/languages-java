package com.decyphr.languages.languages;

import java.util.List;

import com.decyphr.languages.languages.dto.LanguageEntity;

public interface ILanguagesRepository {
    public List<LanguageEntity> getAllLanguages();
    public LanguageEntity getLanguageByCodeOrShortCode(String codeOrShortCode);
    public LanguageEntity getLanguageById(int id);
}
