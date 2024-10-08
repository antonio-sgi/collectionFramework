package com.example;

import java.util.function.Predicate;

public class Filtro implements Predicate<Object> {

    @Override
    public boolean test(Object obj) {
        // if (obj  instanceof Empleado empleado && empleado.getGenero().equals(Genero.MUJER)) {
        //   return true ;
        // } else
        //    return false;

        return obj instanceof Empleado empleado && empleado.getGenero().equals(Genero.MUJER);

    }

}
