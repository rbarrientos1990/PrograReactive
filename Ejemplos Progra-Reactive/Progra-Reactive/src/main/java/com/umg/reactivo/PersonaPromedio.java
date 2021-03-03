package com.umg.reactivo;

import dto.Persona;
import rx.Observable;
import rx.observables.MathObservable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonaPromedio {

    public static void main(String[] args) {

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, 32));
        personas.add(new Persona(2, 33));
        personas.add(new Persona(3, 34));
        personas.add(new Persona(4, 35));
        personas.add(new Persona(5, 36));
        personas.add(new Persona(6, 37));


        Double promedio = personas.stream()
                .collect(Collectors.averagingInt(Persona::getEdad));

                    System.out.println("PROMEDIO:"+ promedio );
                };
    }

