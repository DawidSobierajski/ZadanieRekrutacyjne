package com.sobierajski.zadanie.data.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
@Builder
public class GroovyScriptDto {
    private String name;

    private String possibleMethodsToCall;

    private String methodToCall;

    private String[] params;

    @ToString.Exclude
    private String script;
}
