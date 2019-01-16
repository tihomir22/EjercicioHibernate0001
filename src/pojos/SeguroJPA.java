/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author sportak
 */
@Entity
@Table(name = "seguro")
public class SeguroJPA implements Serializable {

    @Id
    @Column(name = "idSeguro")
    private int id;

}
