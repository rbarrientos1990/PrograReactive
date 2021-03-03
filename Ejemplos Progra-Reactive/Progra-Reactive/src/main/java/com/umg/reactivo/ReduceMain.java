/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umg.reactivo;

import rx.Observable;
import rx.functions.Func2;

/**
 * @author mmendez
 */
public class ReduceMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Integer[] numbers = {1, 2, 3, 4, 5};


        Double resultado;

        Observable resultadoReduce = Observable.from(numbers)
        .reduce(
                // siempre debo tener un acumulador y un valor actual
                new Func2<Integer, Integer, Integer>() {
                    @Override
                    public Integer call(Integer anterior, Integer actual) {
                        Integer resultadoAcumulacion = anterior + actual;
                        return resultadoAcumulacion;
                    }
                }
        );
        resultadoReduce.subscribe((sumatoria) -> {
            System.out.println("resultado1:" + sumatoria);
        });


    }

}
