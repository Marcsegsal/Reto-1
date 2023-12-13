import java.util.Scanner;

public class ModuloUsuario {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int eleccionMenu;

        do {
            mostrarMenu();
            eleccionMenu = scanner.nextInt();

            if (eleccionMenu < 0 || eleccionMenu > 3) {
                System.out.println("El número introducido no es válido, por favor introduce otro número");
            }
            switch (eleccionMenu) {
                case 1:
                    generarPeticion();
                    System.out.println();
                    break;
                case 2:
                    modificarDescripcion();
                    System.out.println();
                    break;
                case 3:
                    consultarPeticion();
                    System.out.println();
                    System.out.println();
                    break;
            }
        } while (eleccionMenu != 0);
    }
    public static void mostrarMenu() {
        System.out.println("0-Salir del programa");
        System.out.println("1-Generar una petición");
        System.out.println("2-Modificar la petición");
        System.out.println("3-Consultar la petición");
    }

    public static void identificarse() {}

    public static void cargarDatosUsuario() {}

    public static void cargarDatosPeticiones() {}

    public static void cargarDatosCategorias() {}

    public static void guardarDatosPeticiones() {}

    public static void generarPeticion() {}

    public static void consultarPeticion() {}

    public static void modificarDescripcion() {}

}