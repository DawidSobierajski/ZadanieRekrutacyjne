package com.sobierajski.zadanie.service;

import com.sobierajski.zadanie.data.dto.GroovyScriptDto;
import com.sobierajski.zadanie.utils.exception.ElementExistsException;
import com.sobierajski.zadanie.utils.exception.ElementNotFoundException;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public interface GroovyScriptService {
    List<GroovyScriptDto> getGroovyScripts();

    void addGroovyScript(@NonNull GroovyScriptDto groovyScriptDto) throws ElementExistsException;

    GroovyScriptDto getGroovyScript(@NonNull String scriptName) throws ElementNotFoundException;

    void updateGroovyScript(@NonNull GroovyScriptDto groovyScriptDto) throws ElementNotFoundException;

    void deleteGroovyScript(@NonNull String scriptName) throws ElementNotFoundException;

    Object runGroovyScript(@NonNull GroovyScriptDto groovyScriptDto) throws ElementNotFoundException;
}
