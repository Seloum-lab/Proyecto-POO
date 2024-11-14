/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modele.Metier.MateriaPrima;
import Modele.Metier.Producto;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author DeLL
 */
public class ProductoDAO {
    public void create(Producto producto) {
        JpaUtil.obtenirContextePersistance().persist(producto);
    }
    
    public void delete(Producto producto) {
        JpaUtil.obtenirContextePersistance().remove(producto);
    }
    
    public void update(Producto producto) {
        JpaUtil.obtenirContextePersistance().merge(producto);
    }
    
    public Producto findById(Long id) {
        return JpaUtil.obtenirContextePersistance().find(Producto.class, id);
    }
    
    
    public List<Producto> getListProducto() {
        List<Producto> liste = null; //On intialise la valeur de retour
        
        
        String query = "SELECT p FROM Producto p order by p.id"; 
        TypedQuery tpQuery = JpaUtil.obtenirContextePersistance().createQuery(query, Producto.class); 
         
        liste = (List<Producto>) tpQuery.getResultList(); 
        
        return liste;
    }
    
    public List<MateriaPrima> getListMateriaExceptProducto(Long id) {
        List<MateriaPrima> liste = null;
        
        String query = "SELECT m FROM MateriaPrima m WHERE NOT EXISTS (SELECT 1 FROM Producto p WHERE m MEMBER OF p.materiaPrimas) ORDER BY m.id";
        TypedQuery tpQuery = JpaUtil.obtenirContextePersistance().createQuery(query, MateriaPrima.class); 
        
        liste = (List<MateriaPrima>) tpQuery.getResultList();
        
        return liste;
        
    }
    
    
}
