package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        
        /* ¿Que es una coleccion? 
         * Es un contenedor, que permite agrupar elementos
         * de distintos tipos como si fuese una unica unidad.
         * 
         * ¿Para que se utilizan las colecciones?
         * Para almacenar, recuperar, manipular y comunicar datos agrupados.
         * 
         * El Framework de Colecciones es un conjunto de Interfaces, con metodos
         * que permiten tratar a todas las colecciones de la misma forma.
         * 
         * 
         */

        // La Interface List es una de las colecciones mas utilizadas,
        // permite almacenar elementos duplicados, al igual que todas las demas
        // interfaces es Generica.
        // ¿Que es la Genericidad? Es lo que permite implementar clases e interfaces
        // que trabajen con tipos de datos diferentes, pero en cada momento solo
        // pueden trabajar con un solo tipo de dato, o datos relacionados.
        // Por lo general un desarrollador no implementa metodos ni elementos (clases,
        // records, etc), sino que debe saber utilizarlos. Solamente los desarrolladores
        // que se dediquen a implementar bibliotecas (librerias) son los que tendran que 
        // dominar la Genericidad a otro nivel.
        // ¿Que ventajas nos ofrece la genericidad? Que los errores se detectan
        // muy facilmente en tiempo de compilacion, en lugar de ejecucion donde
        // seria mucho mas dificil de detectar.

        // Declaracion de Colecciones
        // IMPORTANTE !!! En el diamante no puede ir ningun tipo de datos primitivos
        // (int, double, float, number) sino su correspondiente envoltorio objeto
        // (Integer, Double, Float)
        // Lista o coleccion de elementos donde cada elemento es de tipo String
        List<String> nombres;

        // Coleccion de numeros enteros
        List<Integer> numeros;

        // Coleccion de Objetos definidos por el usuario
        List<Persona> personas;

        // Coleccion que admite elementos de tipo Persona y todos los que hereden
        // de Persona, por ejemplo, Estudiante, Trabajador
        // (Generics)
        // https://docs.oracle.com/javase/tutorial/extra/generics/index.html

        /* Breve explicacion, un poco mas profunda de la Genericidad */
        // La siguiente coleccion admitiria elementos de cualquier tipo
        // pero se desaconseja crear colecciones totalmente genericas
        // porque cuesta trabajo manejar la coleccion posteriormente.
        List<?> elementos;

        // ¿Que es lo que se aconseja, entonces?
        // Acotar por encima o por debajo el tipo, es decir, establecer un 
        // limite.

        // Por tanto, si queremos tener una coleccion que admita Persona y todos
        // los subtipos de persona.
        List<? super Persona> elementosVarios;

        // Importante
        // No permite almacenar elementos porque crea una lista inmutable,
        // ¿Y, para que sirve entonces? Para pasarla como parametro a determinados
        // metodos.
        List<? extends Persona> elementVar2;

        /*
         * ¿Como agregar elementos a una coleccion?
        */

        // Comenzando por la coleccion de nombres

        /*
         * Primero: A partir de una array existente.
         */

        String[] arrayNombres = {"Marcos", "Juan", "Antonio"};

        // ¿Como convertir al array anterior a una lista de nombres?
        nombres = Arrays.asList(arrayNombres);

        System.out.println("Lista de nombres");
        System.out.println(nombres);

        // ¿Que desventajas tiene crear una lista a partir de un array?
        // Que la lista resultante es de tamaño fijo, es decir, que no 
        // le puedes agregar elementos con el metodo add(), posteriormente.

        // nombres.add("Ivan");

        /* Otra forma de agregar elementos a una coleccion es utilizando
         * metodos estaticos de la propia interface, lo cual genera una list
         * inmutable, es decir, de tamaño fijo y que ademas no se puede ni modificar
         * sus elementos.
         */
        List<String> nombres2 = List.of("Ruben", "Ivan");

        /* Por ultimo: Crear una lista a partir de una clase que implemente los metodos
         * de la interface, ArrayList, por ejemplo.
         * Y este tipo de lista si se puede modificar.
         */

         List<String> nombres3 = new ArrayList<>();

         nombres3.add("Ivan");
         nombres3.add("Antonio");

         /*
          * Crear una lista de Personas
          *
          * 1. A partir de un array
          */
        //  Persona persona1;
        //  Persona persona2;
        //  Persona persona3;

        //  persona1 = Persona.builder()
        //     .nombre("Marcos")
        //     .genero(Genero.HOMBRE)
        //     .build();
 
        // persona2 = Persona.builder()
        //     .nombre("Antonio")
        //     .genero(Genero.HOMBRE)
        //     .build();

        // persona3 = Persona.builder()
        //     .nombre("Ruben")
        //     .genero(Genero.HOMBRE)
        //     .build();

         Persona[] personasArray = {
            Persona.builder()
            .nombre("Marcos")
            .genero(Genero.HOMBRE)
            .build(),

            Persona.builder()
            .nombre("Antonio")
            .genero(Genero.HOMBRE)
            .build(),

            Persona.builder()
            .nombre("Ruben")
            .genero(Genero.HOMBRE)
            .build()
          };

          personas = Arrays.asList(personasArray);

          // Crear una lista de personas modificable

          List<Persona> personas2 = new ArrayList<>();

          personas2.add(Persona.builder()
                    .nombre("Marcos")
                    .genero(Genero.HOMBRE)
                    .build());

          personas2.add(Persona.builder()
                    .nombre("Ruben")
                    .genero(Genero.HOMBRE)
                    .build());

          personas2.add(Persona.builder()
                    .nombre("Elli")
                    .genero(Genero.MUJER)
                    .build());

          personas2.add(Persona.builder()
                    .nombre("Maria Fernanda")
                    .genero(Genero.MUJER)
                    .build());

          /* Agregar elementos a la lista de elementosVarios */

          elementosVarios = new ArrayList<>();

          // Agregar una persona
          elementosVarios.add(
              Persona.builder()
                  .nombre("Marcos")
                  .genero(Genero.HOMBRE)
                  .build()          
           );

          // Agregar un empleado
          elementosVarios.add(
            Empleado.builder()
                .nombre("Antonio")
                .genero(Genero.HOMBRE)
                .departamento(Departamento.INFORMATICA)
                .salario(3500.78)
                .build()          
          );

          // Agregar un empleado
          elementosVarios.add(
            Empleado.builder()
                .nombre("Elli")
                .genero(Genero.MUJER)
                .departamento(Departamento.RRHH)
                .salario(3200.78)
                .build()          
          );

          // Agregar un empleado
          elementosVarios.add(
            Empleado.builder()
                .nombre("Maria")
                .genero(Genero.MUJER)
                .departamento(Departamento.FINANZAS)
                .salario(3600.50)
                .build()          
          );

          // Agregar un estudiante
          elementosVarios.add(
            Estudiante.builder()
                .nombre("Ruben")
                .genero(Genero.HOMBRE)
                .totalAsignaturas(10)
                .beca(10500.00)
                .build()          
          );

          // Agregar un estudiante
          elementosVarios.add(
            Estudiante.builder()
                .nombre("Marcos")
                .genero(Genero.HOMBRE)
                .totalAsignaturas(11)
                .beca(11500.00)
                .build()          
          );

          // Agregar un estudiante
          elementosVarios.add(
            Estudiante.builder()
                .nombre("Juan")
                .genero(Genero.HOMBRE)
                .totalAsignaturas(9)
                .beca(9500.00)
                .build()          
          );

          /*
           * Recorrer colecciones (Traversing Collections)
           * 
           * 1. Utilizando un iterador (Interfaz Iterator), es la unica forma
           * de eliminar un elemento de la coleccion mientras se recorre.
           * 
           * 2. Utilizando un for mejorado.
           * 
           * 3. La FORMA SUGERIDA (RECOMENDADA). Utilizando Operaciones de Agregado (Metodos
           * de la clase Stream, las espresiones Lambda y los Metodos por referenca).
           */

           /* Utilizando un iterador (Interface Iterator), vamos a recorrer la coleccion de personas2, para eliminar
           * para eliminar las personas del genero HOMBRE
           */
          Iterator<Persona> i = personas2.iterator();

          System.out.println("Listado de persona2, original");
          System.out.println(personas2);
        //   while (i.hasNext()) {
        //       if (i.next().getGenero().equals(Genero.HOMBRE))
        //           i.remove(); 
        //   }
          System.out.println("Personas del genero MUJER resultantes");
          System.out.println(personas2);

        /* Ejercicio # 1 
        * 
        * Utilizando un Iterador
        * 
        * Recorrer la coleccion de personas2 y mostrar las personas del genero HOMBRE, que ademas tengan
        * un nombre con una longitud igual o menor a 5 caracteres
        */
        // Iterator<Persona> i2 = personas2.iterator();

        // System.out.println("Ejercicio # 1" SOLUCION MAL - cada vez que ejecuta next va al siguiente);
        // while (i2.hasNext()) {
        //     if (i2.next().getGenero().equals(Genero.HOMBRE) && i2.next().getNombre().length() <= 5)
        //     System.out.println(personas2);
        // }

        Iterator<Persona> iterator = personas2.iterator();

        System.out.println("Ejercicio # 1");
        while (iterator.hasNext()) {
            Persona persona = iterator.next();
            if (persona.getGenero().equals(Genero.HOMBRE) && persona.getNombre().length() <= 5)
                System.out.println(persona);
        }

        /*
         * Utilizando la sentencia for mejorada, recorrer la lista de elementosVarios y calcular el
         * promedio de las becas otorgadas a los estudiantes.
         * 
         * Vamos a emplear Pattern Matching (A partir de Java 11 ha surgido)
         */

         double sumatoriaBecas = 0;
         int studentCounter = 0;
         double promedioBecas = 0;

         for (Object obj : elementosVarios){
                // ¿Como saber el tipo de objeto (obj) extraido de la coleccion?
                // Rta. Utilizando el operador instanceof, y tambien Pattern Matching
                if (obj instanceof Estudiante estudiante) {
                  sumatoriaBecas += estudiante.getBeca();
                  studentCounter++;
                } else if (obj instanceof Empleado empleado){
                        ;
                } else {
                    // Seria una persona
                }
          }             

         promedioBecas = sumatoriaBecas / studentCounter;

        System.out.println("El promedio de dinero de las becas de los estudiantes es: " + promedioBecas);

        /*
          Utilizando Operaciones de Agregado, que implica el uso de:

          1. Metodos de la clase Stream: 
          2. Concepto de Tuberia (pipeline). https://docs.oracle.com/javase/tutorial/collections/streams/index.html
          3. Interfaces Funcionales
          4. Clase Anonima
          5. Expresiones Lambda
          6. Metodos por referencia

          Recorrer la coleccion de elementosVarios para obtener el salario promedio de los empleados
         * del genero MUJER
         */
        // Hay que crear o instanciar un objeto de la clase Filtro
        // Filtro filtro = new Filtro();

        // elementosVarios.stream().filter(filtro)

        // El tipo Opcional es una cajita donde puede venir el resultado o null, por tanto
        // te protege del NullPointerException


        // OptionalDouble opcionalDePromedio = elementosVarios.stream().filter(new Filtro()).mapToDouble(new Mapeador()).average();

        // if (opcionalDePromedio.isPresent())
        //       System.out.println("El salario promedio es " + opcionalDePromedio.getAsDouble());
          
        /* ¿Que es una clase Anonima? Es una expresion de clas. Es un tipo de clase que se declara y se
         * instancia en el mismo sitio donde se va a consumir. Por lo general se utilza para implementar
         * interfaces anque tamben se puede utilizar a partir de clases.
         */

         /* Ejemplo:

          * Para ver la sintaxis: Consideremos la interfaz Saludo
          */

          Saludo saludo = new Saludo() {

            private String nombre;

            @Override
            public void hola(String nombre) {
                this.nombre = nombre;
                System.out.println("Hola " + this.nombre);
            } 

          };

          saludo.hola("Ruben");

          /* Ejercicio # 1
           * 
           * Solucionar el ejemplo de calcular el salario promedio de los
           * empleados del genero MUJER, utilizando clases anonimas para implementar
           * las interfaces funcionales que requieren los metodos filter y mapToDouble,
           * es decir, no utilizar las clases Filtro y Mapeador
           */

          OptionalDouble opcionalDePromedio = elementosVarios.stream()
          .filter(new Predicate<Object>() {

            @Override
            public boolean test(Object obj) {
                return obj instanceof Empleado empleado &&
                         empleado.getGenero().equals(Genero.MUJER);
            }
            
          }).mapToDouble(new ToDoubleFunction<Object>() {

            @Override
            public double applyAsDouble(Object obj) {
                Empleado empleado = (Empleado) obj;
                return empleado.getSalario();
            }
            
          }).average();

          double salarioDePromedio;
          
          if (opcionalDePromedio.isPresent())
                System.out.println("El salario promedio es " + opcionalDePromedio.getAsDouble());



    }
}
