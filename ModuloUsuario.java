import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ModuloUsuario {
    static Scanner scanner = new Scanner(System.in);
    static Usuario usuarioEncontrado;
    static int idIngresada;
    static String passwordIngresada;
    static boolean loginExitoso = false;

    static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    static ArrayList<Categoria> categorias=new ArrayList<>();
    static ArrayList<Peticion> peticiones = new ArrayList<>();
    public static void main(String[] args) {
        int eleccionMenu;

        do {
            cargarDatosUsuario();
            mostrarMenu();
            eleccionMenu = scanner.nextInt();

            if (eleccionMenu < 0 || eleccionMenu > 3) {
                System.out.println("El número introducido no es válido, por favor introduce otro número");
            }
            if (eleccionMenu == 0)
                guardarDatosPeticiones();
            
            switch (eleccionMenu) {
                case 1:
                    generarPeticion();
                    System.out.println();
                    break;
                case 2:
                    ArrayList<Peticion> peticionesUsuario = filtrarPeticionesPorUsuario(usuarioActual.getId());
                    imprimirPeticiones(peticionesUsuario);
                    //modificarDescripcion();
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

    public static void cargarDatosUsuario() {
        try {
            BufferedReader f_ent = new BufferedReader(new FileReader(new File("./CSV/usuario.csv")));
            String linea = f_ent.readLine();
            linea = f_ent.readLine();

            while (linea != null) {
                String[] palabras = linea.split(",");
                usuarios.add(new Usuario((Integer.parseInt(palabras[0])), palabras[1], palabras[2]));
                linea = f_ent.readLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void cargarDatosPeticiones() {
        try {
            BufferedReader f_ent = new BufferedReader(new FileReader(new File("./CSV/peticion.csv")));
            String linea = f_ent.readLine();
            linea = f_ent.readLine();

            while (linea != null) {
                String[] palabras = linea.split(",");
                peticiones.add(new Peticion((Integer.parseInt(palabras[0])), Integer.parseInt(palabras[1]), palabras[2], palabras[3], Integer.parseInt(palabras[4]), Integer.parseInt(palabras[5]), Integer.parseInt(palabras[6]), stringToBoolean(palabras[7])));
            }
            f_ent.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void cargarDatosCategorias() {
        try{
            BufferedReader f_in= new BufferedReader(new FileReader(new File("./CSV/categoria.csv")));
            String fila=f_in.readLine();
            while(fila !=null){
                String[] atributo =fila.split(",");
                categorias.add(new Categoria((Integer.parseInt(atributo[0])),atributo [1]));
                fila= f_in.readLine();
            }
            f_in.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void guardarDatosPeticiones() {
        try {
            PrintWriter f_sal = new PrintWriter(new FileWriter("./CSV/peticion.csv"));
            Peticion peticion;

            for (int i = 0; i < peticiones.size(); i++) {
                peticion = peticiones.get(i);
                f_sal.println(peticion.getId() + "," + peticion.getIdUsuario() + "," + peticion.getDescripcion() + "," + peticion.getFecha() + "," + peticion.getIdCategoria() + "\n");
            }
            f_sal.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void generarPeticion() {}

    public static void consultarPeticion() {}

    public static ArrayList<Peticion> filtrarPeticionesPorUsuario(int idUsuario) {
        ArrayList<Peticion> peticionesUsuario = new ArrayList<>();

        for (int i = 0; i < peticionesUsuario.size(); i++) {
            if (idUsuario == peticiones.get(i).getIdUsuario()) {
                peticionesUsuario.add(peticiones.get(i));
            }
        }
        return peticionesUsuario;
    }

    public static void imprimirPeticiones(ArrayList<Peticion> listaPeticiones) {
        for (Peticion peticion : listaPeticiones) {
            System.out.println();
        }
    }

    public static boolean stringToBoolean(String s) {
        boolean b;
        if (s.equals("true")) {
            b = true;
        } else
            b = false;

        return b;
    }
}
