package com.sobierajski.zadanie.controller;

import com.sobierajski.zadanie.data.dto.GroovyScriptDto;
import com.sobierajski.zadanie.service.GroovyScriptService;
import com.sobierajski.zadanie.utils.exception.ElementExistsException;
import com.sobierajski.zadanie.utils.exception.ElementNotFoundException;
import com.sobierajski.zadanie.utils.exception.RunScriptException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping(ScriptController.ENDPOINT)
public class ScriptController {
    static final String ENDPOINT = "/script";

    private final GroovyScriptService groovyScriptService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GroovyScriptDto> getScripts() {
        return groovyScriptService.getGroovyScripts();
    }

    @GetMapping("/{scriptName}")
    @ResponseStatus(HttpStatus.OK)
    public GroovyScriptDto getScript(@PathVariable @NonNull String scriptName) throws ElementNotFoundException {
        return groovyScriptService.getGroovyScript(scriptName);
    }

    /*
    *   POST REQUESTBODY EXAMPLE:
    *   {
    *        "name": "pow",
    *        "script": "def pow(long a, long n) {...}",
    *        "possibleMethodsToCall":"pow(a,n)"
    *   }
    *
    * */

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addScript(@RequestBody @NonNull GroovyScriptDto groovyScriptAddDto) throws ElementExistsException {
        groovyScriptService.addGroovyScript(groovyScriptAddDto);
    }

    /*
    PUT REQUESTBODY EXAMPLE:
        {
            "name":"pow",
            "possibleMethodsToCall":"procedurka",
            "script":"def procedurka(n) {...}"
        }

     */

    @PutMapping()
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateScript(@RequestBody @NonNull GroovyScriptDto groovyScriptUpdateDto) throws ElementNotFoundException {
        groovyScriptService.updateGroovyScript(groovyScriptUpdateDto);
    }

    /*
    DELETE REQUEST PATH EXAMPLE:
        localhost:8080/script/pow
     */
    @DeleteMapping("/{scriptName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteScript(@PathVariable @NonNull String scriptName) throws ElementNotFoundException {
        groovyScriptService.deleteGroovyScript(scriptName);
    }

    /*
    REQUESTBODY TO RUN SCRIPT EXAMPLE:
        {
            "name":"pow",
            "methodToCall":"pow",
            "params":[
                "2","2"
            ]
        }
     */
    @GetMapping("/run")
    @ResponseStatus(HttpStatus.OK)
    public Object runScript(@RequestBody @NonNull GroovyScriptDto script) throws ElementNotFoundException, RunScriptException {
        return groovyScriptService.runGroovyScript(script);
    }
}

