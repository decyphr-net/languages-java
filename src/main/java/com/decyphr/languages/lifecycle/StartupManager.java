package com.decyphr.languages.lifecycle;

import org.springframework.stereotype.Component;

import com.decyphr.languages.languages.LanguagesManager;

@Component
public class StartupManager {

    LanguagesManager languagesManager;

    public StartupManager(LanguagesManager languagesManager) {
        this.languagesManager = languagesManager;
    }

    /**
     * Populate internal memory cache
     */
    public void populateLanguageCache() {
        languagesManager.populateLanguageCache();
    }
}
