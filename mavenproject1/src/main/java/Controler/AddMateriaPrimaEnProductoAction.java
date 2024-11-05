/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import Modele.Service.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DeLL
 */
public class AddMateriaPrimaEnProductoAction extends Action {

    @Override
    public void execute(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        Long productoId = (Long) session.getAttribute("ProductoID");
        Long materiaPrimaId = Long.parseLong(req.getParameter("MateriaID"));
        boolean success = false;
        
        try {
            success = Service.addMateriaPrimaEnProducto(productoId, materiaPrimaId);
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            req.setAttribute("success", success);
        }
    }
    
}
