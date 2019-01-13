/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import connection.Connection;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import pojos.Seguro;

/**
 *
 * @author sportak
 */
public class controladorCRUD {

    private Session conexion;

    public controladorCRUD() {
        conexion = Connection.getSessionFactory().openSession();
    }

    public void insertar(Seguro seg) {
        conexion.beginTransaction();
        conexion.save(seg);
        conexion.getTransaction().commit();
    }

    public Seguro leer(int id) {
        conexion.beginTransaction();
        Query query = conexion.createQuery("from Seguro where idSeguro = :id ");
        query.setParameter("id", id);
        ArrayList<?> list = (ArrayList<?>) query.list();
        Seguro seguro = (Seguro) list.get(0);
        //    System.out.println(seguro);
        conexion.getTransaction().commit();
        return seguro;
    }

    public void actualizar(Seguro seg) {
        conexion.beginTransaction();
        conexion.update(seg);
        conexion.getTransaction().commit();
        System.out.println("Actualizado con exito!");
    }

    public void eliminar(Seguro seg) {
        conexion.beginTransaction();
        conexion.delete(seg);
        conexion.getTransaction().commit();
    }

}
