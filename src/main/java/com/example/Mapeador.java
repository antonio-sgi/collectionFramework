package com.example;

import java.util.function.ToDoubleFunction;

public class Mapeador implements ToDoubleFunction<Object>{

    @Override
    public double applyAsDouble(Object obj) {
        // A continuacion estamosusando un Type casting (un casteo),
        // es decir, convirtiendo a un tipo concreto el objeto que circula
        // por la tuberia.
        return ((Empleado) obj).getSalario();        
    }

}
