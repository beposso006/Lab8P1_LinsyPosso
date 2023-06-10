/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab8p1_linsyposso;
import java.util.Scanner;
/**
 *
 * @author CARMEN POSSO
 */
public class Lab8P1_LinsyPosso {
static Scanner Leer = new Scanner (System.in);
private Libro[][] librero;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Libro[][] librero = null;
         boolean seguir = true;
        
        while (seguir){
            System.out.println(" MENU ");
            System.out.println("1.Crear biblioteca");
            System.out.println("2.Modificar librero");
            System.out.println("3.Salir");
            System.out.println("Ingrese una opcion: ");
            int op = Leer.nextInt();
            
            switch (op){
                case 1:
                    System.out.print("Ingrese la cantidad de filas para el librero: ");
                    int filas = Leer.nextInt();

                    System.out.print("Ingrese la cantidad de columnas para el librero: ");
                    int columnas = Leer.nextInt();

                    librero = llenarLibrero(filas, columnas, Leer);

                    System.out.println("\nEl librero completo es:");
                    mostrarLibrero(librero);
                    break;
                    
                case 2:
                    Leer.nextLine();
                    if (librero == null) {
                        System.out.println("Como va a modifcar el librero si no tiene libros. Regrese al 1 :)");
                    } else {
                        System.out.print("\nIngrese el título del libro: ");
                        String tituloBusqueda = Leer.nextLine();

                        System.out.print("Ingrese el escritor: ");
                        String escritorBusqueda = Leer.nextLine().trim();

                        System.out.print("Ingrese el año de publicación: ");
                        int añoPublicacionBusqueda = Leer.nextInt();

                        modificarLibro(tituloBusqueda, escritorBusqueda, añoPublicacionBusqueda, librero, Leer);

                        System.out.println("\nEl librero modificado es:");
                        mostrarLibrero(librero);
                    }
                    break;
                     case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
                    }
        }
    }
          
     public static Libro[][] llenarLibrero(int filas, int columnas, Scanner scanner) {
    Libro[][] librero = new Libro[filas][columnas];
        int librosIngresados = 0;

        while (librosIngresados < filas * columnas) {
            System.out.println("Ingrese el título del libro: ");
            String titulo = scanner.next();

            System.out.print("Ingrese el escritor: ");
            String escritor = scanner.next();

            System.out.print("Ingrese el año de publicación: ");
            int añoPublicacion = scanner.nextInt();

            scanner.nextLine();

            Libro libro = new Libro(titulo, escritor, añoPublicacion);
            librero[librosIngresados / columnas][librosIngresados % columnas] = libro;
            librosIngresados++;

            System.out.println("El libro fue agregado exitosamente");
        }

        return librero;
    }

    public static void mostrarLibrero(Libro[][] librero) {
        for (int i = 0; i < librero.length; i++) {
            for (int j = 0; j < librero[i].length; j++) {
                System.out.print("[ " + librero[i][j].getTitulo() + " ] ");
            }
            System.out.println();
        }
    }
    public static void modificarLibro(String tituloBusqueda, String escritorBusqueda, int añoPublicacionBusqueda,
    Libro[][] librero, Scanner scanner) {
        for (int i = 0; i < librero.length; i++) {
            for (int j = 0; j < librero[i].length; j++) {
                Libro libro = librero[i][j];
                if (libro.getTitulo().equals(tituloBusqueda) &&
                        libro.getEscritor().equals(escritorBusqueda) &&
                        libro.getAñoPublicacion() == añoPublicacionBusqueda) {

                    System.out.println("El libro fue encontrado en la fila " + (i + 1) + " columna " + (j + 1));

                    System.out.print("Ingrese el nuevo título del libro: ");
                    String nuevoTitulo = scanner.next();

                    System.out.print("Ingrese el nuevo escritor: ");
                    String nuevoEscritor = scanner.next();

                    System.out.print("Ingrese el nuevo año de publicación: ");
                    int nuevoAñoPublicacion = scanner.nextInt();

                    scanner.nextLine();

                    libro.setTitulo(nuevoTitulo);
                    libro.setEscritor(nuevoEscritor);
                    libro.setAñoPublicacion(nuevoAñoPublicacion);

                    System.out.println("El libro fue modificado exitosamente");
                    return;
                }
            }
        }
        System.out.println("El libro no fue encontrado en el librero.");
    }
}
        
                    
    
     

