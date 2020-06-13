package com.sobierajski.zadanie.service;

import com.sobierajski.zadanie.data.dto.GroovyScriptDto;
import com.sobierajski.zadanie.data.entity.GroovyScript;
import com.sobierajski.zadanie.utils.exception.ElementExistsException;
import lombok.NonNull;

import java.util.List;

public interface GroovyScriptService {
    List<GroovyScript> getGroovyScripts();

    void addGroovyScript(@NonNull GroovyScriptDto groovyScriptDto) throws ElementExistsException;

}
