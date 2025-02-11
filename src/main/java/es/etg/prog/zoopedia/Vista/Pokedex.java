package main.java.es.etg.prog.zoopedia.Vista;
import main.java.es.etg.prog.zoopedia.Controlador.Controlador;

public class Pokedex {
    public static void main(String[] args) {
        int opcion = -1;
        do{
            System.out.println("ZOOPEDIA");
            System.out.println("-- MENÚ PRINCIAL --");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Registrar animal");
            System.out.println("3. Mostrar información del animal");
            System.out.println("0. Finalizar programa");
            System.out.print("Digite una opción: ");
            opcion = Controlador.validarNumentero();
            switch (opcion) {
                case 1:
                    Controlador.registrarUsuario();
                    break;
                case 2:
                    Controlador.registrarAnimal();
                    break;
                case 3:
                    Controlador.mostrarAnimales();
                    break;
                case 4:
                    Controlador.cambiarFavorito();
                    break;
                case 0:
                    System.out.println("Saliendo del programa,,,,");
                    System.exit(0);
                default:
                    System.out.println("OPCIÓN NO VÁLIDA");
                    break;
            }
        }while (opcion!=0);
    }
}