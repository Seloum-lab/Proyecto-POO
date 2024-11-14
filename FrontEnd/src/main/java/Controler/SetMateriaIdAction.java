/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DeLL
 */
public class SetMateriaIdAction extends Action {

    @Override
    public void execute(HttpServletRequest req) {
        Long id = Long.parseLong(req.getParameter("MateriaID"));
        HttpSession session = req.getSession(false);
        session.setAttribute("MateriaID", id); 
        req.setAttribute("success", true); 
        
    }
    
}
