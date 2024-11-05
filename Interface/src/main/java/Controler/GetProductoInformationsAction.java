/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import Modele.Metier.Producto;
import Modele.Service.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DeLL
 */
public class GetProductoInformationsAction extends Action {

    @Override
    public void execute(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        Long id = (Long) session.getAttribute("ProductoID");
        Producto producto = null;
        
        try {
            producto = Service.getProductoById(id);
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            req.setAttribute("Producto", producto);
        }
        
        
        
        
    }
    
}
