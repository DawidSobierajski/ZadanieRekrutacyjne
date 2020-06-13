package com.sobierajski.zadanie.data.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GroovyScriptDto {
    private String name;
    private String script;
}
