package com.umg.reactivo;

import dto.Persona;
import rx.Observable;
import rx.functions.Func2;

import java.util.ArrayList;
import java.util.List;

public class MapReduce {
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5};


        List<Persona> personas = new ArrayList<>();

        Persona datoPersona = new Persona(0,31);
        personas.add(datoPersona);
        personas.add(new Persona(1, 32));
        personas.add(new Persona(2, 33));
        personas.add(new Persona(3, 34));
        personas.add(new Persona(4, 35));
        personas.add(new Persona(5, 36));

        Observable miobservable =
                Observable
                        // se envia el streaming de personas...
                        .from(personas.toArray())
                        /* sin embargo se intercepta para usar unicamente el campo que necesito calcular, esto ocurre
                        antes del reduce */
                        .map((result) -> {
                            // por cada persona.... transformar a Integer !! con la funcion MAP
                            // mapea el objeto del streaming a un valor en el cual se pueda calcular
                            Persona persona = (Persona) result;
                            return persona.getEdad();
                        })
                        // cuando llega al reduce, lo que ya recibo es unicamente datos enteros
                        .reduce(
                                new Func2<Integer, Integer, Integer>() {
                                    @Override
                                    public Integer call(Integer acumulador, Integer actual) {
                                        // System.out.println("Actual:"+actual);
                                        return acumulador + actual;
                                    }
                                }
                        );

        miobservable.subscribe((sumatoria) -> {
            System.out.println("" +
                    "Sumatoria:" + sumatoria);
        });








       /* miobservable.subscribe((sumatoria) -> {
            System.out.println("resultado2:" + sumatoria);

            // enviar a servicio rest
        });*/
    }
}
