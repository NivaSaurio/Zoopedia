package main.java.es.etg.prog.zoopedia.Controlador;


import java.util.InputMismatchException;
import java.util.Scanner;

import main.java.es.etg.prog.zoopedia.Modelo.Animal;
import main.java.es.etg.prog.zoopedia.Modelo.Nivel;
import main.java.es.etg.prog.zoopedia.Modelo.Tipo;
import main.java.es.etg.prog.zoopedia.Modelo.Usuario;

public class Controlador {
    //Estos son atributos de la clase, necesita scanner y un objeto usuario (este usuario a su vez tiene una estructura de datos en sus atributos "animal")
    static Scanner sc = new Scanner(System.in);
    static Usuario usuario;
    //private static final String MSG_
    private static final String MSG_ERROR_NUMERO = "Solo puedes introducir un número";
    private static final String MSG_ERROR_RESPUESTA = "Solo puedes introducir SI/NO";
    private static final String MSG_INICIO_REGISTRO = "¡Vamos a empezar con el registro!";
    private static final String MSG_REGISTRO = "Para empezar introduce el nombre: ";
    private static final String MSG_CONFIRMACION = "¿Los datos introducidos son correctos? (SI/NO): ";
    private static final String MSG_ERROR_YA_REGISTRADO = "No puedes volver a registrar un usuario";
    private static final String MSG_EROR_REG_ANIMAL = "No puedes crear un animal sin haberte registrado.";
    private static final String MSG_REG_TIPO = "Selecciona el tipo del animal (1 / 2 / 3)";
    private static final String MSG_TIPO_TERRESTRE = "1. TERRESTRE";
    private static final String MSG_TIPO_VOLADOR = "3. VOLADOR";
    private static final String MSG_TIPO_ACUATICO = "2. ACUATICO";
    private static final String MSG_ERROR_TIPO = "Opción no válida. Por favor, selecciona una opción válida.";

    //Métodos estáticos para que pueda usarlos en OTROS métodos o OTRAS clases, sin necesidad de crear instancias para su uso en OTRAS clases
    

    /*En validarRespuesta(), la salida del bucle es controlada por un return, que interrumpe el ciclo y el método al mismo tiempo.
    En validarNumentero(), como estamos manejando excepciones y esperando una entrada válida,
    usamos un break para salir del ciclo después de que el número sea ingresado correctamente, sin tener que salir del método prematuramente con un return. */

    public static int validarNumentero() {
        int numEntero = -1;
        while (true) {
            try {
                numEntero = sc.nextInt();  // Intenta leer un número entero
                sc.nextLine();
                break;  // Si la lectura es correcta, termina el ciclo
                
            } catch (InputMismatchException e) {
                System.out.println(MSG_ERROR_NUMERO);
                sc.nextLine();  // Limpiar el buffer de entrada para que no quede un valor incorrecto
            }
        }
        return numEntero;
    }

    public static String validarRespuesta() {
        String respuesta = "";
        while (true) {
            respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("si") || respuesta.equalsIgnoreCase("no")) {
                return respuesta;
            } else {
                System.out.println(MSG_ERROR_RESPUESTA);
            }
        }
    }
    

    public static void registrarUsuario(){
        if(usuario == null){
            usuario = new Usuario();
            String respuesta = "";//confirma si los datos introducidos son correctos
            boolean repetir;
            System.out.println(MSG_INICIO_REGISTRO);
            do {
                repetir = false;
                System.out.println(MSG_REGISTRO);
                String nombre = sc.nextLine();
                if(nombre!=null && !nombre.trim().isEmpty()){
                    usuario.setNombre(nombre);
                    System.out.println(MSG_CONFIRMACION + usuario.getNombre());
                    respuesta = validarRespuesta();
                    if(respuesta.equalsIgnoreCase("no")){
                        repetir = true;
                    }
                }else{
                    System.out.println("No puedes dejar vacío el nombre");
                    repetir = true;
                }
            } while (repetir);
        }else{
            System.out.println(MSG_ERROR_YA_REGISTRADO);
        }
    }

    public static void registrarAnimal(){
        boolean repetir;
        String respuesta = "";
        if(usuario!=null){
            do {
                repetir = false;
                Animal animal = new Animal();
                registrarNombreAnimal(animal);
                registrarTipo(animal);
                registrarCuernos(animal);
                registrarColmillos(animal);
                determinarNivel(animal);
                determinarPuntos(animal);
                System.out.println("quieres marcar este animal como favorito? solo puedes tener 1 favorito, puedes cambiarlo cuando quieras");
                respuesta = validarRespuesta();
                if(respuesta.equalsIgnoreCase("si")){
                    marcarFavorito(animal);
                }else{
                    System.out.println("Continuemos con el registro " + MSG_CONFIRMACION + animal);
                    respuesta = sc.nextLine();
                    if(respuesta.equalsIgnoreCase("no")){
                        repetir = true;
                    }else{
                        usuario.agregarAnimal(animal);
                        System.out.println("Quieres añadir más animales? ");
                        respuesta = sc.nextLine();
                        if(respuesta.equalsIgnoreCase("si")){
                            repetir = true;
                        }
                    }
                }
            } while (repetir);
        }else{
            System.out.println(MSG_EROR_REG_ANIMAL);
        }
    }

    public static void repani(Animal animal){
        System.out.println(animal);
    }

    public static void registrarNombreAnimal(Animal animal){
        while (true) {
            System.out.println(MSG_REGISTRO);
            String nombre = sc.nextLine();
            if(nombre != null && !nombre.trim().isEmpty()){
                animal.setNombre(nombre);
                break;
            }
        }
    }

    public static void registrarTipo(Animal animal){
        while (true) {
            System.out.println(MSG_REG_TIPO);
            System.out.println(MSG_TIPO_TERRESTRE);
            System.out.println(MSG_TIPO_ACUATICO);
            System.out.println(MSG_TIPO_VOLADOR);
            int opcion = validarNumentero();
    
            switch (opcion) {
                case 1:
                    animal.setTipo(Tipo.TERRESTRE);
                    break;
                case 2:
                animal.setTipo(Tipo.ACUATICO);
                    break;
                case 3:
                animal.setTipo(Tipo.VOLADOR);
                    break;
                default:
                    System.out.println(MSG_ERROR_TIPO);
                    sc.nextLine();
                    continue;
            }
            break;
        }
    }

    public static void registrarCuernos(Animal animal){
        System.out.print("Introduce el número de cuernos del animal: ");
        int numCuernos = validarNumentero();
        animal.setNumCuernos(numCuernos);
    }

    public static void registrarColmillos(Animal animal){
        System.out.print("Num colmillos: ");
        int numColmillos = sc.nextInt();
        animal.setNumColmillos(numColmillos);
    }

    public static void determinarNivel(Animal animal) {
        if (animal.getNumCuernos() == 0 && animal.getNumColmillos() == 0) {
            animal.setNivel(Nivel.NORMAL);
        } else if (animal.getNumCuernos() <= 2 && animal.getNumColmillos() <= 2) {
            animal.setNivel(Nivel.RARO);
        } else if (animal.getNumCuernos() > 2 || animal.getNumColmillos() > 2) { // || (tipo == Tipo.VOLADOR && (numCuernos > 0 || numColmillos > 0))
            animal.setNivel(Nivel.POKEMON);
        } else {
            throw new IllegalArgumentException("Nivel no definido para este animal.");
        }
    }

    public static void determinarPuntos(Animal animal){
        if(animal.getNivel() == Nivel.NORMAL){
            animal.setPuntos(10);
        }else if(animal.getNivel() == Nivel.RARO){
            animal.setPuntos(20);
        }else{
            animal.setPuntos(30);
        }
    }
    
    public static void marcarFavorito(Animal animal){
        for(Animal animalArray : usuario.getListaAnimales()){
            animalArray.setFavorito(false);
        }
        animal.setFavorito(true);
        System.out.println(animal.getNombre() + "se marcó como fav");
    }

    public static void calcularPuntos(Animal animal){
        int puntos = 0;
        for(Animal animalArray : usuario.getListaAnimales()){
            puntos+= animalArray.getPuntos();
        }
        usuario.setPuntos(puntos);
    }

    public static void mostrarAnimales(){
        for (Animal animal : usuario.getListaAnimales()) {
            System.out.println("Nobre del animal: " + animal.getNombre());
            System.out.println("Tipo de animal: " + animal.getTipo());
            System.out.println("Número de cuernos del animal: " + animal.getNumCuernos());
            System.out.println("Número de colmillos del animal: " + animal.getNumColmillos());
            System.out.println("Nivel del animal: " + animal.getNivel());
            System.out.println("Puntos del animal: " + animal.getPuntos());
        }
    }
}