package com.sobierajski.zadanie.utils.mapper;

import com.sobierajski.zadanie.data.dto.GroovyScriptDto;
import com.sobierajski.zadanie.data.entity.GroovyScript;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Mapper {
    public String map(byte[] array) {
        return new String(array);
    }

    public byte[] map(String s) {
        return s.getBytes();
    }


    public GroovyScriptDto map(GroovyScript script) {
        return GroovyScriptDto.builder()
                .name(script.getName())
                .script(map(script.getScript()))
                .build();
    }

    public GroovyScript map(GroovyScriptDto groovyScriptDto) {
        return GroovyScript.builder()
                .name(groovyScriptDto.getName())
                .script(map(groovyScriptDto.getScript()))
                .build();
    }
}
