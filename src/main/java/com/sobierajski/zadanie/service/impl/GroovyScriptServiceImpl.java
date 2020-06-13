package com.sobierajski.zadanie.service.impl;

import com.sobierajski.zadanie.data.dto.GroovyScriptDto;
import com.sobierajski.zadanie.data.entity.GroovyScript;
import com.sobierajski.zadanie.data.repository.GroovyScriptRepository;
import com.sobierajski.zadanie.service.GroovyScriptService;
import com.sobierajski.zadanie.utils.exception.ElementExistsException;
import com.sobierajski.zadanie.utils.exception.ElementNotFoundException;
import com.sobierajski.zadanie.utils.mapper.Mapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class GroovyScriptServiceImpl implements GroovyScriptService {
    @NonNull
    private final GroovyScriptRepository groovyScriptRepository;
    @NonNull
    private final Mapper mapper;

    @Override
    public List<GroovyScriptDto> getGroovyScripts() {
        return groovyScriptRepository.findAll()
                .stream()
                .map(mapper::map)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void addGroovyScript(@NonNull GroovyScriptDto groovyScriptDto) throws ElementExistsException {
        Optional<GroovyScript> script = groovyScriptRepository.findById(groovyScriptDto.getName());
        if (script.isPresent()) {
            throw new ElementExistsException(groovyScriptDto.toString());
        }
        GroovyScript groovyScript = mapper.map(groovyScriptDto);
        groovyScriptRepository.save(groovyScript);
    }

    @Override
    @Transactional
    public GroovyScriptDto getGroovyScript(@NonNull String scriptName) throws ElementNotFoundException {
        Optional<GroovyScript> gs = groovyScriptRepository.findById(scriptName);
        if (gs.isPresent()) {
            return mapper.map(gs.get());
        } else throw new ElementNotFoundException(scriptName);
    }

    @Override
    @Transactional
    public void updateGroovyScript(@NonNull GroovyScriptDto groovyScriptDto) throws ElementNotFoundException {
        Optional<GroovyScript> gs = groovyScriptRepository.findById(groovyScriptDto.getName());
        if (gs.isPresent()) {
            GroovyScript script = gs.get();
            script.setScript(mapper.map(groovyScriptDto.getScript()));
            groovyScriptRepository.save(script);
        } else throw new ElementNotFoundException(groovyScriptDto.toString());
    }

    @Override
    public void deleteGroovyScript(@NonNull String scriptName) throws ElementNotFoundException {
        Optional<GroovyScript> gs = groovyScriptRepository.findById(scriptName);
        if (gs.isPresent()) {
            groovyScriptRepository.delete(gs.get());
        } else throw new ElementNotFoundException(scriptName);
    }

    @Override
    public Object runGroovyScript(@NonNull GroovyScriptDto groovyScriptDto) throws ElementNotFoundException {
        return null;
    }
}
