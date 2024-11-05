/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import Modele.Metier.Cuenta;
import Modele.Service.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DeLL
 */
public class SignInAction extends Action{

    @Override
    public void execute(HttpServletRequest req) {
        String mail = req.getParameter("mail");
        String password = req.getParameter("password");
        Cuenta cuenta = null;
        HttpSession session = req.getSession(true);
        
        
        try {
            cuenta = Service.autenticate(mail, password);
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            req.setAttribute("cuenta", cuenta);
            if (cuenta != null){
                session.setAttribute("id", cuenta.getId());
                req.setAttribute("cuenta", cuenta);
            }
        }
    }
    
}
