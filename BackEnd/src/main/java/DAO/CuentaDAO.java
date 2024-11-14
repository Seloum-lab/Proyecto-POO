/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modele.Metier.Cuenta;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author DeLL
 */
public class CuentaDAO {
    public void create(Cuenta cuenta) {
        JpaUtil.obtenirContextePersistance().persist(cuenta);
    }
    
    public void delete(Cuenta cuenta) {
        JpaUtil.obtenirContextePersistance().remove(cuenta);
    }
    
    public void update(Cuenta cuenta) {
        JpaUtil.obtenirContextePersistance().merge(cuenta);
    }
    
    public Cuenta findById(Long id) {
        return JpaUtil.obtenirContextePersistance().find(Cuenta.class, id);
    }
    
    public Cuenta findByMail(String mail) {
        Cuenta res = null; //On intialise la valeur de retour
        try {
        String query = "SELECT c FROM Cuenta c WHERE c.mail = :mail"; 
        TypedQuery tpQuery = JpaUtil.obtenirContextePersistance().createQuery(query, Cuenta.class); 
        tpQuery.setParameter("mail", mail); 
        
        res = (Cuenta) tpQuery.getSingleResult(); // retourne le Cuenta trouve 
        } catch (NoResultException ex) { //Si il n'y a pas de résultat
            res = null;            
        }
        return res;
    }
}
