/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import DAO.JpaUtil;
import Modele.Service.Service;

/**
 *
 * @author DeLL
 */
public class Main {
    public static void main(String[] args) {
        JpaUtil.creerFabriquePersistance();
        
        Service.addMateriaPrima("cacao");
        Service.addMateriaPrima("azucar", 50);
        Service.addProducto("chocolat", 0);
        Service.addMateriaPrimaEnProducto((long) 1, (long) 1);
        Service.addCuenta("selim@selim.com", "selim", "nombre", "rol", true);
        
        
        System.out.println(Service.getListeMateriaPrima());
        System.out.println(Service.getListeProducto());
        System.out.println(Service.getMateriPrimaDeUnProducto((long) 1));
        System.out.println(Service.getMateriaPrimaExeptoProducto( (long)1));
        
        
        
        JpaUtil.fermerFabriquePersistance();
        
    }
    
}
