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
public class AddMateriaPrimaAction extends Action{

    @Override
    public void execute(HttpServletRequest req) {
        String nombre = req.getParameter("nombre");
        Integer cantitad = Integer.parseInt(req.getParameter("cantitad"));
        boolean success = false;
        
        try {
            success = Service.addMateriaPrima(nombre, cantitad);
            
        } catch(Exception ex) {
            System.out.println(ex);
        } finally {
            req.setAttribute("success", success);
        }
    }
    
}
