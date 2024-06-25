package com.decyphr.languages.languages;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import com.decyphr.languages.languages.dto.LanguageModel;

public class LanguagesSingleton {
    
    private static LanguagesSingleton instance;
    @Getter
    @Setter
    private List<LanguageModel> languages;
    
    private LanguagesSingleton() { }

    public static LanguagesSingleton getInstance() {
        if (instance == null) {
            instance = new LanguagesSingleton();
        }

        return instance;
    }
}
