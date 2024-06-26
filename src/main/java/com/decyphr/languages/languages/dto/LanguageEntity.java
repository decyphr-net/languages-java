package com.decyphr.languages.languages.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LanguageEntity {
    private int id;
    private String name;
    private String code;
    private String shortCode;

    public LanguageEntity(String name, String code, String shortCode) {
        this.name = name;
        this.code = code;
        this.shortCode = shortCode;
    }
}
