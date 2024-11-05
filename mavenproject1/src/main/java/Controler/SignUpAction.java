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
public class SignUpAction extends Action{

    @Override
    public void execute(HttpServletRequest req) {
        String mail = req.getParameter("mail");
        String nombre = req.getParameter("nombre");
        String role = req.getParameter("role");
        String password = req.getParameter("password");
        boolean isAdmin;
        boolean success = false;
        isAdmin = Boolean.parseBoolean(req.getParameter("isAdmin"));
        
        try {
            success = Service.addCuenta(mail, password, nombre, role, isAdmin);
        } catch (Exception ex) {
            
        } finally {
            System.out.println(success + "Debugging dans signupAction");
            req.setAttribute("signUp", success);
        }
              
    }
    
}
