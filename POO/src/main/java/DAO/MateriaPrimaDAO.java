/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import Modele.Metier.MateriaPrima;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author DeLL
 */
public class MateriaPrimaDAO {
    public void create(MateriaPrima materiaPrima) {
        JpaUtil.obtenirContextePersistance().persist(materiaPrima);
    }
    
    public void delete(MateriaPrima materiaPrima) {
        JpaUtil.obtenirContextePersistance().remove(materiaPrima);
    }
    
    public void update(MateriaPrima materiaPrima) {
        JpaUtil.obtenirContextePersistance().merge(materiaPrima);
    }
    
    public MateriaPrima findById(Long id) {
        return JpaUtil.obtenirContextePersistance().find(MateriaPrima.class, id);
    }
    
    public List<MateriaPrima> getListMateriaPrima() {
        List<MateriaPrima> liste = null; //On intialise la valeur de retour
        
        
        String query = "SELECT m FROM MateriaPrima m order by m.id"; 
        TypedQuery tpQuery = JpaUtil.obtenirContextePersistance().createQuery(query, MateriaPrima.class); 
         
        liste = (List<MateriaPrima>) tpQuery.getResultList(); 
        
        return liste;
    }
    
    
    
}
