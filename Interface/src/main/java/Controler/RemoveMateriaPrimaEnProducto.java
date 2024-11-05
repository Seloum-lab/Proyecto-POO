/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import Modele.Service.Service;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author DeLL
 */
public class RemoveMateriaPrimaEnProducto extends Action{

    @Override
    public void execute(HttpServletRequest req) {
        Long productoId = Long.parseLong(req.getParameter("productoId"));
        Long materiaPrimaId = Long.parseLong(req.getParameter("materiaPrimaId"));
        boolean success = false;
        
        try {
            success = Service.removeMateriaPrimaEnProducto(productoId, materiaPrimaId);
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            req.setAttribute("success", success);
        }
    }
    
}
