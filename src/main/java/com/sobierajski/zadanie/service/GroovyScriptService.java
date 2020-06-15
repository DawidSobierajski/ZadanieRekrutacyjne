package com.sobierajski.zadanie.service;

import com.sobierajski.zadanie.data.dto.GroovyScriptDto;
import com.sobierajski.zadanie.utils.exception.ElementExistsException;
import com.sobierajski.zadanie.utils.exception.ElementNotFoundException;
import com.sobierajski.zadanie.utils.exception.RunScriptException;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroovyScriptService {
    List<GroovyScriptDto> getGroovyScripts();

    void addGroovyScript(@NonNull GroovyScriptDto groovyScriptDto) throws ElementExistsException;

    GroovyScriptDto getGroovyScript(@NonNull String scriptName) throws ElementNotFoundException;

    void updateGroovyScript(@NonNull GroovyScriptDto groovyScriptDto) throws ElementNotFoundException;

    void deleteGroovyScript(@NonNull String scriptName) throws ElementNotFoundException;

    Object runGroovyScript(@NonNull GroovyScriptDto script) throws ElementNotFoundException, RunScriptException;
}
