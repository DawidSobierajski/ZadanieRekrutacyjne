package com.sobierajski.zadanie.data.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class GroovyScript {
    @Id
    String name;
    byte[] script;
}
