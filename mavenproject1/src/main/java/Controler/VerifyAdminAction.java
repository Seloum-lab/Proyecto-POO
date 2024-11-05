/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import Modele.Metier.Administrador;
import Modele.Metier.Cuenta;
import Modele.Service.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DeLL
 */
public class VerifyAdminAction extends Action{

    @Override
    public void execute(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        Long id = (Long) session.getAttribute("id");
        boolean success = false;
        Cuenta cuenta = null;
        
        try {
            cuenta = Service.getCuentaById(id);
            if (cuenta != null && cuenta instanceof Administrador) {
                success = true;
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
        
        req.setAttribute("success", success);
    }
    
}
