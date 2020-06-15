package com.sobierajski.zadanie.data.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity()
public class GroovyScript {
    @Id
    @NonNull
    private String name;

    @NonNull
    private String possibleMethodsToCall;

    @Column(length = 5000, nullable = false)
    @NonNull
    private byte[] script;
}
