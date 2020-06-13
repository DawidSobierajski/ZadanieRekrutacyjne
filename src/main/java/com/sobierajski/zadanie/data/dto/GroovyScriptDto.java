package com.sobierajski.zadanie.data.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
public class GroovyScriptDto {
    private String name;
    @ToString.Exclude
    private String script;
}
