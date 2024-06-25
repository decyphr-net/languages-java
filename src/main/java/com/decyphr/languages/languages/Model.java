package com.decyphr.languages.languages;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Model {
    private int id;
    private String name;
    private String code;
    private String shortCode;

    protected Model(String name, String code, String shortCode) {
        this.name = name;
        this.code = code;
        this.shortCode = shortCode;
    }
}
