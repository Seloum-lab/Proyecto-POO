/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele.Service;

import DAO.CuentaDAO;
import DAO.JpaUtil;
import DAO.MateriaPrimaDAO;
import DAO.ProductoDAO;
import Modele.Metier.Administrador;
import Modele.Metier.Cuenta;
import Modele.Metier.MateriaPrima;
import Modele.Metier.Producto;
import Modele.Metier.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author DeLL
 */
public class Service {
    public static boolean addMateriaPrima(String nombre, Integer cantitad) {
        boolean res = false;
        MateriaPrimaDAO materiaPrimaDAO = new MateriaPrimaDAO();
        MateriaPrima materiaPrima = new MateriaPrima(nombre, cantitad);
        
        
        try {
            JpaUtil.creerContextePersistance();
            JpaUtil.ouvrirTransaction();
            materiaPrimaDAO.create(materiaPrima);
            JpaUtil.validerTransaction();
            res = true;
        } catch (Exception ex) {
            JpaUtil.annulerTransaction();
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return res;
    }
    
    public static boolean addMateriaPrima(String nombre) {
        
        
        boolean res = false;
        MateriaPrimaDAO materiaPrimaDAO = new MateriaPrimaDAO();
        MateriaPrima materiaPrima = new MateriaPrima(nombre);
        
        
        try {
            JpaUtil.creerContextePersistance();
            JpaUtil.ouvrirTransaction();
            materiaPrimaDAO.create(materiaPrima);
            JpaUtil.validerTransaction();
            res = true;
        } catch (Exception ex) {
            System.out.println(ex);
            JpaUtil.annulerTransaction();
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return res;
    }
    
    
    public static boolean addProducto(String nombre, Integer cantitad) {
        boolean res = false;
        ProductoDAO productoDAO = new ProductoDAO();
        Producto producto = new Producto(nombre, cantitad);
        
        try {
            JpaUtil.creerContextePersistance();
            JpaUtil.ouvrirTransaction();
            productoDAO.create(producto);
            JpaUtil.validerTransaction();
            res = true;
        } catch (Exception ex) {
            JpaUtil.annulerTransaction();
        } finally {
            JpaUtil.fermerContextePersistance();           
        }
        
        return res;
    }
    
    
    public static boolean removeMateriaPrimaEnProducto(Long productoId, Long materiaPrimaId) {
        boolean res = false;
        ProductoDAO productoDAO = new ProductoDAO();
        MateriaPrimaDAO materiaPrimaDAO = new MateriaPrimaDAO();
        Producto producto = null;
        MateriaPrima materiaPrima = null;
               
        try {
            JpaUtil.creerContextePersistance();
            JpaUtil.ouvrirTransaction();
            producto = productoDAO.findById(productoId);
            materiaPrima = materiaPrimaDAO.findById(materiaPrimaId);
            Set<MateriaPrima> materiaPrimas = producto.getMateriaPrimas();
            materiaPrimas.remove(materiaPrima);
            producto.setMateriaPrimas(materiaPrimas); 
            productoDAO.update(producto);
            JpaUtil.validerTransaction();
            res = true;
        } catch(Exception ex) {
            JpaUtil.annulerTransaction();
        } finally {
            JpaUtil.fermerContextePersistance();
        }
          
        
        return res;
    }
    
    
    public static boolean addMateriaPrimaEnProducto(Long productoId, Long materiaPrimaId) {
        boolean res = false;
        ProductoDAO productoDAO = new ProductoDAO();
        MateriaPrimaDAO materiaPrimaDAO = new MateriaPrimaDAO();
        Producto producto = null;
        MateriaPrima materiaPrima = null;
               
        try {
            JpaUtil.creerContextePersistance();
            JpaUtil.ouvrirTransaction();
            producto = productoDAO.findById(productoId);
            materiaPrima = materiaPrimaDAO.findById(materiaPrimaId);
            Set<MateriaPrima> materiaPrimas = producto.getMateriaPrimas();
            materiaPrimas.add(materiaPrima);
            producto.setMateriaPrimas(materiaPrimas); 
            productoDAO.update(producto);
            JpaUtil.validerTransaction();
            res = true;
        } catch(Exception ex) {
            JpaUtil.annulerTransaction();
        } finally {
            JpaUtil.fermerContextePersistance();
        }
          
        
        return res;
    }
    
    
    public static boolean addQuantityPrimerMateria(Long primeraMateriaID, int newQuantity) {
        boolean res = false;
        MateriaPrima materiaPrima = null;
        MateriaPrimaDAO materiaPrimaDAO = new MateriaPrimaDAO();
        int quantity;
        
        try {
            JpaUtil.creerContextePersistance();
            JpaUtil.ouvrirTransaction();
            materiaPrima = materiaPrimaDAO.findById(primeraMateriaID);
            quantity = materiaPrima.getCantitad() + newQuantity;
            materiaPrima.setCantitad(quantity);
            materiaPrimaDAO.update(materiaPrima);
            JpaUtil.validerTransaction();
            res = true;            
        } catch (Exception ex) {
            JpaUtil.annulerTransaction();            
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        
        return false;
    }
    
    
    public static boolean addQuantityProducto (Long productoId, int newQuantity) {
        boolean res = false;
        Producto producto = null;
        ProductoDAO productoDAO = new ProductoDAO();
        int quantity;
        
        try {
            JpaUtil.creerContextePersistance();
            JpaUtil.ouvrirTransaction();
            producto = productoDAO.findById(productoId);
            quantity = producto.getCantitad() + newQuantity;
            producto.setCantitad(quantity);
            productoDAO.update(producto);
            JpaUtil.validerTransaction();
            res = true;
        } catch (Exception ex) {
            JpaUtil.annulerTransaction();
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        
        
        return res;
    }
    
    
    public static boolean addCuenta(String mail, String password, String nombre, String rol, boolean isAdmin) {
        boolean res = false;
        CuentaDAO cuentaDAO = new CuentaDAO();
        Cuenta cuenta = null;
        if (isAdmin) {
            cuenta = new Administrador(mail, password, nombre, rol);
        }
        else {
            cuenta = new User(mail, password, nombre, rol);
        }
        
        try {
            JpaUtil.creerContextePersistance();
            JpaUtil.ouvrirTransaction();
            cuentaDAO.create(cuenta);
            JpaUtil.validerTransaction();
            res = true;
        } catch(Exception ex) {
            JpaUtil.annulerTransaction();
            System.out.println(ex);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        
        
        return res;
    }
    
    
    public static Cuenta autenticate(String mail, String password) {
        Cuenta cuenta = null;
        CuentaDAO cuentaDAO = new CuentaDAO();
        
        try {
            JpaUtil.creerContextePersistance();
            cuenta = cuentaDAO.findByMail(mail);
            if (cuenta == null ? false : !cuenta.getPassword().equals(password)) 
                cuenta = null;
        } catch(Exception ex) {
            System.err.println(ex);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        
        return cuenta;
    }
    
    
    public static List<MateriaPrima> getListeMateriaPrima() {
        List<MateriaPrima> result = null;
        MateriaPrimaDAO materiaPrimaDAO = new MateriaPrimaDAO();
        try {
            JpaUtil.creerContextePersistance();
            result = materiaPrimaDAO.getListMateriaPrima();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        
        return result;
    }
    
    public static List<Producto> getListeProducto() {
        List<Producto> result = null;
        ProductoDAO productoDAO = new ProductoDAO();
        try {
            JpaUtil.creerContextePersistance();
            result = productoDAO.getListProducto();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        
        return result;
    }
    
    public static List<MateriaPrima> getMateriPrimaDeUnProducto(Long productoId) {
        List<MateriaPrima> result = null;
        ProductoDAO productoDAO = new ProductoDAO();
        
        try {
            JpaUtil.creerContextePersistance();
            result = new ArrayList<> (productoDAO.findById(productoId).getMateriaPrimas());
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        
        return result;
    }
    
    public static List<MateriaPrima> getMateriaPrimaExeptoProducto(Long productoId) {
        List<MateriaPrima> result = null;
        ProductoDAO productoDAO = new ProductoDAO();
        
        try {
            JpaUtil.creerContextePersistance();
            result = new ArrayList<>(productoDAO.getListMateriaExceptProducto(productoId));
        } catch (Exception ex) {
            System.err.println(ex);
        } finally {
            JpaUtil.fermerContextePersistance();
        } 
        
        
        return result;
    }
    
    public static Producto getProductoById(Long id) {
        Producto producto = null;
        ProductoDAO productoDAO = new ProductoDAO();
        
        try {
            JpaUtil.creerContextePersistance();
            producto = productoDAO.findById(id);
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        
        return producto;
    } 
    
    public static MateriaPrima getMateriaById(Long id) {
        MateriaPrima materiaPrima = null;
        MateriaPrimaDAO materiaPrimaDAO = new MateriaPrimaDAO();
        
        try {
            JpaUtil.creerContextePersistance();
            materiaPrima = materiaPrimaDAO.findById(id);
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return materiaPrima;
    }

    public static Cuenta getCuentaById(Long id) {
        Cuenta cuenta = null;
        CuentaDAO cuentaDAO = new CuentaDAO();
        
        try {
            JpaUtil.creerContextePersistance();
            cuenta = cuentaDAO.findById(id);
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            JpaUtil.fermerContextePersistance();
        }
        return cuenta;
    }
    
    
    
}
