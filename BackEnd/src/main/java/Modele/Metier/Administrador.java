/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele.Metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author DeLL
 */
@Entity
@DiscriminatorValue("Admin")
public class Administrador extends Cuenta {
    
    public Administrador() {
        super();
    }
    
    public Administrador(String mail, String password, String nombre, String rol) {
        super(mail, password, nombre, rol);
    }
    
}
