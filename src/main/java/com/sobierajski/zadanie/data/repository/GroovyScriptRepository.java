package com.sobierajski.zadanie.data.repository;

import com.sobierajski.zadanie.data.entity.GroovyScript;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroovyScriptRepository extends JpaRepository<GroovyScript,String> {

}
