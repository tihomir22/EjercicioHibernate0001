/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import connection.Connection;
import controlador.controladorCRUD;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import org.hibernate.Session;
import pojos.Seguro;

/**
 *
 * @author sportak
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion = 999;
        Scanner teclado = new Scanner(System.in);
        String nif, nombre, ape1, ape2, respuesta;
        int edad, hijos, id;
        Seguro seguro1 = null, activo = null;
        controladorCRUD con = new controladorCRUD();
        
        while (opcion != 0) {
            mostrarMenu();
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Introduzca NIF");
                    nif = teclado.nextLine();
                    System.out.println("Introduzca Nombre");
                    nombre = teclado.nextLine();
                    System.out.println("Introduzca apellidos primeros");
                    ape1 = teclado.nextLine();
                    System.out.println("Introduzca apellidos segundos");
                    ape2 = teclado.nextLine();
                    System.out.println("Introduzca edad");
                    edad = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println("Introduzca numero de hijos ");
                    hijos = teclado.nextInt();
                    seguro1 = new Seguro(nif, nombre, ape1, ape2, edad, hijos, Calendar.getInstance().getTime());
                    con.insertar(seguro1);
                    break;
                
                case 2:
                    System.out.println("Introduzca ID");
                    id = teclado.nextInt();
                    teclado.nextLine();
                    activo = con.leer(id);
                    if (activo != null) {
                        System.out.println("Recuperado " + activo);
                    } else {
                        System.out.println("No existe el objeto");
                    }
                    break;
                
                case 3:
                    if (activo != null) {
                        System.out.println("Deseas usar el objeto que seleccionaste anteriormente? S/N \n " + activo.toString());
                        respuesta = teclado.nextLine();
                        if (respuesta.equalsIgnoreCase("N")) {
                            System.out.println("Introduzca ID del objeto a actualizar");
                            id = teclado.nextInt();
                            teclado.nextLine();
                            activo = con.leer(id);
                            System.out.println("Recuperado " + activo);
                        }
                    } else {
                        System.out.println("Introduzca ID del objeto a actualizar");
                        id = teclado.nextInt();
                        activo = con.leer(id);
                        System.out.println("Recuperado " + activo);
                    }
                    System.out.println("Introduzca NIF");
                    activo.setNif(teclado.nextLine());
                    System.out.println("Introduzca Nombre");
                    activo.setNombre(teclado.nextLine());
                    System.out.println("Introduzca apellidos primeros");
                    activo.setApe1(teclado.nextLine());
                    System.out.println("Introduzca apellidos segundos");
                    activo.setApe2(teclado.nextLine());
                    System.out.println("Introduzca edad");
                    activo.setEdad(teclado.nextInt());
                    teclado.nextLine();
                    System.out.println("Introduzca numero de hijos ");
                    activo.setNumHijos(teclado.nextInt());
                    teclado.nextLine();
                    con.actualizar(activo);
                    break;
                
                case 4:
                    System.out.println("Introduzca ID del objeto a eliminar");
                    id = teclado.nextInt();
                    teclado.nextLine();
                    activo = con.leer(id);
                    if (activo != null) {
                        System.out.println("Eliminado con exito " + activo.toString());
                        con.eliminar(activo);
                    } else {
                        System.out.println("No existe el objeto");
                    }
                    break;
            }
        }
        Connection.getSessionFactory().close();
        
    }
    
    public static void mostrarMenu() {
        System.out.println("1.- Insertar un objeto Seguro en la BBDD");
        System.out.println("2.- Leer un objeto Seguro de la BBDD");
        System.out.println("3.- Actualizar un objeto Seguro de la BBDD");
        System.out.println("4.- Borrar un objeto Seguro de la BBDD");
    }
    
}
