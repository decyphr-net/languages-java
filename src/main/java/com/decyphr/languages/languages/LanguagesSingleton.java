package com.decyphr.languages.languages;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import org.springframework.stereotype.Component;

import com.decyphr.languages.languages.dto.LanguageEntity;

@Component
public class LanguagesSingleton {
    
    private static LanguagesSingleton instance;
    @Getter
    @Setter
    private List<LanguageEntity> languages = null;
    
    private LanguagesSingleton() { }

    public static LanguagesSingleton getInstance() {
        if (instance == null) {
            System.out.println("Creating new singleton instance");
            instance = new LanguagesSingleton();
        } else {
            System.out.println("Reusing singleton instance");
        }

        return instance;
    }

    public LanguageEntity getLanguageByCodeOrShortCode(String codeOrShortCode) {
        for (LanguageEntity language : languages) {
            if (
                    language.getCode() == codeOrShortCode 
                    || language.getShortCode() == codeOrShortCode) {
                return language;
            } else {
                continue;
            }
        }

        return null;
    }

    public LanguageEntity getLanguageById(int id) {
        System.out.println(id);
        System.out.println(languages.size());
        for (LanguageEntity language : languages) {
            if (language.getId() == id) {
                return language;
            } else {
                continue;
            }
        }

        return null;
    }
}
