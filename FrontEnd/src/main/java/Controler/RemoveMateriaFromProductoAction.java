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
public class RemoveMateriaFromProductoAction extends Action{

    @Override
    public void execute(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        Long productoID = (Long) session.getAttribute("ProductoID");
        Long materiaID = Long.parseLong(req.getParameter("MateriaID"));
        boolean success= false;
        
        try {
            success = Service.removeMateriaPrimaEnProducto(productoID, materiaID);
        } catch(Exception ex) {
            System.err.println(ex);
        } finally {
            req.setAttribute("success", success);
        }
        
    }
    
}
